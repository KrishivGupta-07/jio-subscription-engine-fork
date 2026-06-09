-- Payment module schema (MariaDB). Flyway is the single source of truth; Hibernate runs in validate mode.

-- ---------------------------------------------------------------------------
-- Core TMF676 / TMF670 resources
-- ---------------------------------------------------------------------------

CREATE TABLE payment (
    id                     VARCHAR(64)    NOT NULL,
    correlator_id          VARCHAR(255),
    status                 VARCHAR(40)    NOT NULL,
    amount_value           DECIMAL(19, 4),
    amount_currency        VARCHAR(3),
    total_amount_value     DECIMAL(19, 4),
    total_amount_currency  VARCHAR(3),
    tax_amount_value       DECIMAL(19, 4),
    tax_amount_currency    VARCHAR(3),
    captured_amount        DECIMAL(19, 4) NOT NULL DEFAULT 0,
    refunded_amount        DECIMAL(19, 4) NOT NULL DEFAULT 0,
    authorization_code     VARCHAR(255),
    description            VARCHAR(1024),
    name                   VARCHAR(255),
    account_id             VARCHAR(64),
    payment_method_id      VARCHAR(64),
    psp_reference          VARCHAR(255),
    payment_date           DATETIME(6),
    status_date            DATETIME(6),
    dto_json               LONGTEXT,
    created_at             DATETIME(6)    NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at             DATETIME(6)    NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    version                BIGINT         NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);
-- MariaDB treats multiple NULLs as distinct in a unique index, so this enforces uniqueness
-- only for non-null correlator ids without needing a (partial) filtered index.
CREATE UNIQUE INDEX ux_payment_correlator ON payment (correlator_id);
CREATE INDEX ix_payment_status ON payment (status);

CREATE TABLE payment_method (
    id                  VARCHAR(64)  NOT NULL,
    type                VARCHAR(40)  NOT NULL,
    name                VARCHAR(255) NOT NULL,
    description         VARCHAR(1024),
    is_preferred        BOOLEAN,
    authorization_code  VARCHAR(255),
    status              VARCHAR(40),
    status_reason       VARCHAR(255),
    status_date         DATETIME(6),
    account_id          VARCHAR(64),
    token_ref           VARCHAR(255),
    valid_for_start     DATETIME(6),
    valid_for_end       DATETIME(6),
    dto_json            LONGTEXT,
    created_at          DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at          DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    version             BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE refund (
    id                     VARCHAR(64)    NOT NULL,
    correlator_id          VARCHAR(255),
    payment_id             VARCHAR(64)    NOT NULL,
    status                 VARCHAR(40)    NOT NULL,
    amount_value           DECIMAL(19, 4),
    amount_currency        VARCHAR(3),
    total_amount_value     DECIMAL(19, 4),
    total_amount_currency  VARCHAR(3),
    tax_amount_value       DECIMAL(19, 4),
    tax_amount_currency    VARCHAR(3),
    authorization_code     VARCHAR(255),
    description            VARCHAR(1024),
    name                   VARCHAR(255),
    account_id             VARCHAR(64),
    payment_method_id      VARCHAR(64),
    psp_reference          VARCHAR(255),
    refund_kind            VARCHAR(20),
    refund_date            DATETIME(6),
    status_date            DATETIME(6),
    dto_json               LONGTEXT,
    created_at             DATETIME(6)    NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at             DATETIME(6)    NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    version                BIGINT         NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT fk_refund_payment FOREIGN KEY (payment_id) REFERENCES payment (id)
);
CREATE UNIQUE INDEX ux_refund_correlator ON refund (correlator_id);
CREATE INDEX ix_refund_payment ON refund (payment_id);

-- ---------------------------------------------------------------------------
-- Append-only audit trail
-- ---------------------------------------------------------------------------

CREATE TABLE payment_state_transition (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    payment_id      VARCHAR(64)  NOT NULL,
    from_state      VARCHAR(40),
    to_state        VARCHAR(40)  NOT NULL,
    reason          VARCHAR(255),
    correlation_id  VARCHAR(255),
    created_at      DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
);
CREATE INDEX ix_transition_payment ON payment_state_transition (payment_id);

CREATE TABLE payment_audit (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    entity_type     VARCHAR(40)  NOT NULL,
    entity_id       VARCHAR(64)  NOT NULL,
    action          VARCHAR(64)  NOT NULL,
    detail          LONGTEXT,
    correlation_id  VARCHAR(255),
    created_at      DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
);
CREATE INDEX ix_audit_entity ON payment_audit (entity_type, entity_id);

-- Enforce append-only at the database level (one trigger per table+event in MariaDB).
CREATE TRIGGER trg_transition_no_update BEFORE UPDATE ON payment_state_transition
    FOR EACH ROW SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'payment_state_transition is append-only';
CREATE TRIGGER trg_transition_no_delete BEFORE DELETE ON payment_state_transition
    FOR EACH ROW SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'payment_state_transition is append-only';
CREATE TRIGGER trg_audit_no_update BEFORE UPDATE ON payment_audit
    FOR EACH ROW SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'payment_audit is append-only';
CREATE TRIGGER trg_audit_no_delete BEFORE DELETE ON payment_audit
    FOR EACH ROW SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'payment_audit is append-only';

-- ---------------------------------------------------------------------------
-- Idempotency + webhook de-duplication
-- ---------------------------------------------------------------------------

CREATE TABLE idempotency_record (
    idem_key              VARCHAR(255) NOT NULL,
    operation             VARCHAR(64)  NOT NULL,
    request_hash          VARCHAR(128),
    status                VARCHAR(20)  NOT NULL,
    response_entity_id    VARCHAR(64),
    response_status_code  INTEGER,
    response_body         LONGTEXT,
    created_at            DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    expires_at            DATETIME(6),
    PRIMARY KEY (idem_key)
);

CREATE TABLE processed_webhook (
    event_id     VARCHAR(255) NOT NULL,
    provider     VARCHAR(64)  NOT NULL,
    payment_id   VARCHAR(64),
    received_at  DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (event_id)
);

-- ---------------------------------------------------------------------------
-- Transactional outbox (events)
-- ---------------------------------------------------------------------------

CREATE TABLE outbox_event (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    aggregate_type  VARCHAR(64)  NOT NULL,
    aggregate_id    VARCHAR(64)  NOT NULL,
    event_type      VARCHAR(128) NOT NULL,
    topic           VARCHAR(128) NOT NULL,
    payload         LONGTEXT     NOT NULL,
    published       BOOLEAN      NOT NULL DEFAULT FALSE,
    attempts        INTEGER      NOT NULL DEFAULT 0,
    created_at      DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    published_at    DATETIME(6),
    PRIMARY KEY (id)
);
CREATE INDEX ix_outbox_unpublished ON outbox_event (published, created_at);

-- ---------------------------------------------------------------------------
-- Dunning
-- ---------------------------------------------------------------------------

CREATE TABLE dunning_attempt (
    id               BIGINT       NOT NULL AUTO_INCREMENT,
    payment_id       VARCHAR(64)  NOT NULL,
    attempt_number   INTEGER      NOT NULL,
    status           VARCHAR(20)  NOT NULL,
    next_attempt_at  DATETIME(6),
    last_error       VARCHAR(1024),
    created_at       DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at       DATETIME(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
);
CREATE INDEX ix_dunning_due ON dunning_attempt (status, next_attempt_at);

-- ---------------------------------------------------------------------------
-- Reconciliation
-- ---------------------------------------------------------------------------

CREATE TABLE reconciliation_exception (
    id               BIGINT        NOT NULL AUTO_INCREMENT,
    settlement_ref   VARCHAR(255),
    payment_id       VARCHAR(64),
    file_name        VARCHAR(255),
    reason           VARCHAR(64)   NOT NULL,
    expected_amount  DECIMAL(19, 4),
    actual_amount    DECIMAL(19, 4),
    detail           LONGTEXT,
    resolved         BOOLEAN       NOT NULL DEFAULT FALSE,
    created_at       DATETIME(6)   NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
);

-- ---------------------------------------------------------------------------
-- ShedLock (once-only scheduled execution across instances)
-- ---------------------------------------------------------------------------

CREATE TABLE shedlock (
    name        VARCHAR(64)  NOT NULL,
    lock_until  DATETIME(6)  NOT NULL,
    locked_at   DATETIME(6)  NOT NULL,
    locked_by   VARCHAR(255) NOT NULL,
    PRIMARY KEY (name)
);
