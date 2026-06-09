package com.jio.subscription.payments.service;

import com.jio.subscription.payments.domain.IdempotencyRecord;
import com.jio.subscription.payments.exception.IdempotencyConflictException;
import com.jio.subscription.payments.repository.IdempotencyRecordRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tools.jackson.databind.ObjectMapper;

/**
 * Guarantees exactly-once execution of a keyed operation across instances and retries.
 *
 * <p>Mechanism: a Redis {@code SET NX PX} lock provides mutual exclusion between concurrent requests
 * for the same key; a durable {@link IdempotencyRecord} (written by the action inside the same
 * transaction) provides replay-safety after completion. The action is committed <em>before</em> the
 * lock is released, so there is no window where a concurrent caller can observe an uncommitted result.
 */
@Service
public class IdempotencyService {

    private static final Logger log = LoggerFactory.getLogger(IdempotencyService.class);

    /** Releases the lock only if we still own it (compare-and-delete), avoiding releasing a re-acquired lock. */
    private static final DefaultRedisScript<Long> RELEASE_SCRIPT = new DefaultRedisScript<>(
            "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end",
            Long.class);

    private final StringRedisTemplate redis;
    private final IdempotencyRecordRepository records;
    private final ObjectMapper objectMapper;
    private final TransactionTemplate transactionTemplate;
    private final Duration lockWait;
    private final Duration lockLease;
    private final Duration recordTtl;

    public IdempotencyService(StringRedisTemplate redis, IdempotencyRecordRepository records,
            ObjectMapper objectMapper, PlatformTransactionManager transactionManager,
            @Value("${payments.idempotency.lock-wait:PT5S}") Duration lockWait,
            @Value("${payments.idempotency.lock-lease:PT30S}") Duration lockLease,
            @Value("${payments.idempotency.ttl:PT24H}") Duration recordTtl) {
        this.redis = redis;
        this.records = records;
        this.objectMapper = objectMapper;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.lockWait = lockWait;
        this.lockLease = lockLease;
        this.recordTtl = recordTtl;
    }

    /**
     * Execute {@code action} exactly once for {@code key}. When {@code key} is blank the action simply
     * runs in a transaction with no idempotency guarantees. The action is responsible for persisting
     * the {@link IdempotencyRecord} (status COMPLETED, with the serialised response) within its
     * transaction so durability is atomic with the business write.
     */
    public <T> IdempotentResult<T> execute(String key, String operation, String requestHash, Class<T> type,
            Supplier<T> action) {
        if (key == null || key.isBlank()) {
            return new IdempotentResult<>(transactionTemplate.execute(status -> action.get()), false);
        }

        String lockKey = "payments:idem:lock:" + operation + ":" + key;
        String token = UUID.randomUUID().toString();
        if (!acquire(lockKey, token)) {
            throw new IdempotencyConflictException(
                    "A request with idempotency key '" + key + "' is already being processed");
        }
        try {
            Optional<IdempotencyRecord> existing = records.findById(key);
            if (existing.isPresent()) {
                IdempotencyRecord record = existing.get();
                assertSamePayload(key, requestHash, record.getRequestHash());
                if (IdempotencyRecord.STATUS_COMPLETED.equals(record.getStatus())
                        && record.getResponseBody() != null) {
                    return new IdempotentResult<>(objectMapper.readValue(record.getResponseBody(), type), true);
                }
                // A prior attempt did not complete (e.g. crash). The action is atomic, so re-running
                // under the lock is safe and will not double-charge.
            }
            T value = transactionTemplate.execute(status -> action.get());
            return new IdempotentResult<>(value, false);
        } finally {
            release(lockKey, token);
        }
    }

    /** Persist the completed idempotency record. Call from within the action's transaction. */
    public void recordCompletion(String key, String operation, String requestHash, String responseBody,
            int statusCode) {
        if (key == null || key.isBlank()) {
            return;
        }
        IdempotencyRecord record = records.findById(key).orElseGet(IdempotencyRecord::new);
        record.setIdemKey(key);
        record.setOperation(operation);
        record.setRequestHash(requestHash);
        record.setStatus(IdempotencyRecord.STATUS_COMPLETED);
        record.setResponseBody(responseBody);
        record.setResponseStatusCode(statusCode);
        if (record.getCreatedAt() == null) {
            record.setCreatedAt(OffsetDateTime.now());
        }
        record.setExpiresAt(OffsetDateTime.now().plus(recordTtl));
        records.save(record);
    }

    public String hash(Object request) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256")
                    .digest(objectMapper.writeValueAsString(request).getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(digest);
        } catch (Exception ex) {
            return null;
        }
    }

    private void assertSamePayload(String key, String incoming, String stored) {
        if (incoming != null && stored != null && !incoming.equals(stored)) {
            throw new IdempotencyConflictException(
                    "Idempotency key '" + key + "' was already used with a different request payload");
        }
    }

    private boolean acquire(String lockKey, String token) {
        long deadline = System.nanoTime() + lockWait.toNanos();
        do {
            Boolean ok = redis.opsForValue().setIfAbsent(lockKey, token, lockLease);
            if (Boolean.TRUE.equals(ok)) {
                return true;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return false;
            }
        } while (System.nanoTime() < deadline);
        return false;
    }

    private void release(String lockKey, String token) {
        try {
            redis.execute(RELEASE_SCRIPT, List.of(lockKey), token);
        } catch (RuntimeException ex) {
            log.warn("Failed to release idempotency lock {}", lockKey, ex);
        }
    }
}
