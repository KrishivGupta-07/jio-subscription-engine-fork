# Payments Module (`module-4-payments`)

TM Forum–compliant payment service for the subscription engine. Implements **TMF676 (Payment)** and
**TMF670 (Payment Method)** as REST APIs backed by a state machine, idempotent processing, a
provider-agnostic PSP gateway, dunning, refunds, reconciliation, and event publishing.

> This README is the living handoff document. It is updated at the end of each build phase so a new
> owner has full context. See [Build status](#build-status) for what is done vs. pending.

---

## Tech stack

| Concern | Choice | Notes |
|---|---|---|
| Language / runtime | Java 21 | `release 21` (builds on newer JDKs) |
| Framework | Spring Boot 4.0.6 | Spring Framework 7, Jakarta EE 11, **Jackson 3** (`tools.jackson`) |
| API contract | OpenAPI Generator 7.22 | TMF interfaces + DTOs generated at build time (see below) |
| Persistence | **MariaDB** (11.4) + Spring Data JPA / Hibernate 7 | Hibernate runs in `validate` mode |
| Schema | **Flyway** (`flyway-mysql`) | Single source of truth; see `db/migration` |
| DTO ↔ entity | MapStruct 1.6 | constructor injection; `MoneyMapper` for `Float`↔`BigDecimal` |
| Caching / locking | Redis (Lettuce) | distributed locks for idempotency (not Spring Data Redis repos) |
| Messaging | Kafka | TMF688-style domain events (transactional outbox) — *pending* |
| Resilience | Resilience4j | wraps PSP gateway — *pending* |
| Scheduling | ShedLock | once-only execution across instances — *pending* |
| Batch | Spring Batch | T+1 reconciliation — *pending* |
| Tests | JUnit 5, Mockito, Testcontainers (MariaDB/Kafka/Redis), MockMvc | WireMock/Awaitility wired for later phases |

### Why these choices
- **MariaDB over Postgres**: chosen per product direction. JSON columns are stored as `LONGTEXT`
  (MariaDB `JSON` is a `LONGTEXT` alias); entities map them with `@JdbcTypeCode(SqlTypes.LONGVARCHAR)`
  so Hibernate `validate` matches deterministically. Append-only enforcement uses `SIGNAL SQLSTATE`
  triggers (MariaDB has no partial indexes or plpgsql).
- **Flyway, not `ddl-auto`**: the schema is a reviewed, versioned artifact. `ddl-auto=validate` only
  checks that entities match the migrated schema.
- **Redis for locking**: low-latency `SET NX PX` mutual exclusion across instances. The *durable*
  idempotency record lives in MariaDB; Redis is only the lock.

---

## Hard constraints (do not violate)

1. **Never edit anything under `target/generated-sources`** — it is regenerated every build from the
   committed Swagger specs in `src/main/resources/openapi`. If the contract must change, change the
   spec, not the Java.
2. **No JPA/persistence annotations on generated DTOs.** Keep separate `@Entity` classes and map with
   MapStruct.
3. **Never persist raw PANs / card numbers.** Store only tokens/references (`payment_method.token_ref`).
4. All hand-written code lives under `com.jio.subscription.payments` so it is component-scanned.

---

## Project layout

```
src/main/java/com/jio/subscription/payments/
  PaymentsApplication.java        # Spring Boot entry point
  domain/                         # JPA @Entity classes + AuditedEntity superclass
  repository/                     # Spring Data JPA repositories
  mapper/                         # MapStruct mappers (PaymentMapper, RefundMapper,
                                  #   PaymentMethodMapper) + MoneyMapper
  statemachine/                   # PaymentState enum + PaymentStateMachine
  exception/                      # PaymentApiException hierarchy (TMF error mapping)
  service/                        # PaymentService, RefundService, PaymentMethodService
  web/                            # Controllers (implement generated TMF interfaces),
                                  #   TmfErrorAdvice, PartialResponse, RequestCorrelation
src/main/resources/
  application.yml                 # datasource/redis/kafka/flyway/actuator/resilience4j config
  db/migration/V1__init.sql       # full schema (MariaDB)
  openapi/*.swagger.json          # TMF676 / TMF670 specs (the API contract)
```

Generated (build output, not committed source):
`target/generated-sources/openapi/.../com/jio/payments/tmf676` and `.../tmf670`.

---

## Data model (V1)

Mutable TMF resources: `payment`, `refund`, `payment_method` (each carries flat queryable columns +
a `dto_json` `LONGTEXT` holding the full TMF resource for fidelity, + `created_at/updated_at/version`).

Append-only (DB triggers reject UPDATE/DELETE): `payment_state_transition`, `payment_audit`.

Supporting: `idempotency_record`, `processed_webhook`, `outbox_event`, `dunning_attempt`,
`reconciliation_exception`, `shedlock`.

Money is stored as `DECIMAL(19,4)` + a currency column; the TMF `Money.value` (a `Float`) is converted
to/from `BigDecimal` at the mapping boundary via `MoneyMapper` (canonical decimal-string conversion to
avoid binary float artifacts).

### Payment state machine
`initiated → authorized → captured → settled` with `failed` reachable from the pre-settlement states,
and `partiallyRefunded` / `refunded` from `captured`/`settled`. `failed` and `refunded` are terminal.
Illegal transitions are rejected (HTTP 409) and never persisted. Every accepted transition is appended
to `payment_state_transition`. The enum value is serialized into the free-form TMF `Payment.status`.

---

## API surface (implemented)

Base paths follow the generated interfaces (no extra context path):

- `POST /payment`, `GET /payment`, `GET /payment/{id}` (TMF676 Payment)
- `POST /refund`, `GET /refund`, `GET /refund/{id}` (TMF676 Refund)
- `POST /paymentMethod`, `GET /paymentMethod`, `GET /paymentMethod/{id}`,
  `PATCH /paymentMethod/{id}`, `DELETE /paymentMethod/{id}` (TMF670)

Conventions honored: pagination via `offset`/`limit`; partial response via `fields`; the TMF `Error`
model for all error responses (`TmfErrorAdvice`); `Location` header on create.

### Idempotency (exactly-once create)

`POST /payment` is idempotent. The key is the `Idempotency-Key` request header, falling back to the
TMF `correlatorId`. Implemented by `IdempotencyService`:

1. **Mutual exclusion** — a Redis `SET NX PX` lock (`payments:idem:lock:{op}:{key}`) serialises
   concurrent requests for the same key. Released via a Lua compare-and-delete so a caller never
   releases a lock it no longer owns. If the lock can't be taken within `lock-wait`, the request is
   rejected `409`.
2. **Durability / replay** — the business write and a `COMPLETED` `idempotency_record` (storing the
   serialised response + a SHA-256 of the request) are committed in the **same transaction** via a
   `TransactionTemplate`, *before* the lock is released. So there is no window where a concurrent
   caller can observe an uncommitted result, and a crash mid-flight commits nothing (no double-create).
3. **Replay** — a subsequent request with the same key returns the stored response with **HTTP 200**
   (the first request returns **201 Created**).
4. **Key reuse guard** — same key + different payload (hash mismatch) → **409 Conflict**.

Config under `payments.idempotency`: `ttl` (record retention), `lock-wait`, `lock-lease`.
`ProcessedWebhook` dedupe (inbound PSP webhook replays) is wired into the schema and will be used by
the webhook phase.

---

## Running locally

Requires Java 21 and a running MariaDB, Redis, and (for events, later) Kafka. Defaults assume
`localhost`; override via env vars (`PAYMENTS_DB_URL`, `PAYMENTS_DB_USER`, `PAYMENTS_DB_PASSWORD`,
`PAYMENTS_REDIS_HOST`, `PAYMENTS_KAFKA_BOOTSTRAP`, ...).

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)   # macOS
./mvnw spring-boot:run
```

### Tests
Integration tests spin up MariaDB/Kafka/Redis automatically via Testcontainers (Docker required).

```bash
./mvnw test
```

---

## Build status

| # | Phase | Status |
|---|---|---|
| 1 | Persistence foundation: deps, `application.yml`, Flyway `V1`, entities, repositories, mappers | ✅ Done |
| — | MariaDB migration (replaced Postgres) | ✅ Done |
| 2 | TMF controllers + TMF error model + payment state machine | ✅ Done |
| 3 | Idempotency (Redis lock + durable record) | ✅ Done |
| 4 | PSP gateway abstraction + Resilience4j | ⏳ Pending |
| 5 | PSP webhook (HMAC) driving state transitions | ⏳ Pending |
| 6 | Refunds (full/partial) integrated with state machine | ⏳ Pending |
| 7 | Dunning & retry (ShedLock) + suspend-product signal | ⏳ Pending |
| 8 | Events: transactional outbox → Kafka (TMF688) | ⏳ Pending |
| 9 | Reconciliation: Spring Batch T+1 settlement job | ⏳ Pending |
| 10 | Observability: metrics, correlation-id logging, probes | ⏳ Pending |
| — | FUTURE-WORK: UPI Autopay + RBI e-mandate (deferred) | ⏳ Pending |

### Notable Spring Boot 4 gotchas (already handled)
- Auto-config is split into per-technology modules: Flyway needs `org.springframework.boot:spring-boot-flyway`;
  `@AutoConfigureMockMvc` is in `org.springframework.boot.webmvc.test.autoconfigure`.
- No `spring-boot-starter-aop` in the BOM — use `org.aspectj:aspectjweaver` directly.
- Testcontainers 2.0 modules are renamed (`testcontainers-mariadb`, `testcontainers-kafka`, ...).
- Two Jackson lines are on the classpath; the Spring default `ObjectMapper` is Jackson 3 (`tools.jackson`).
```
