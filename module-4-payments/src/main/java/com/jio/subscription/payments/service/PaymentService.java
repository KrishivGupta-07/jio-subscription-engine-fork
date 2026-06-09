package com.jio.subscription.payments.service;

import com.jio.payments.tmf676.model.AccountRef;
import com.jio.payments.tmf676.model.Payment;
import com.jio.payments.tmf676.model.PaymentCreate;
import com.jio.payments.tmf676.model.PaymentMethodRefOrValue;
import com.jio.subscription.payments.domain.PaymentAudit;
import com.jio.subscription.payments.domain.PaymentEntity;
import com.jio.subscription.payments.exception.ResourceNotFoundException;
import com.jio.subscription.payments.mapper.PaymentMapper;
import com.jio.subscription.payments.repository.PaymentAuditRepository;
import com.jio.subscription.payments.repository.PaymentRepository;
import com.jio.subscription.payments.statemachine.PaymentStateMachine;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class PaymentService {

    static final String HREF_PREFIX = "/payment/";
    private static final int DEFAULT_LIMIT = 20;
    private static final int MAX_LIMIT = 100;

    private static final String CREATE_OPERATION = "createPayment";

    private final PaymentRepository payments;
    private final PaymentAuditRepository audit;
    private final PaymentMapper mapper;
    private final PaymentStateMachine stateMachine;
    private final ObjectMapper objectMapper;
    private final IdempotencyService idempotency;

    public PaymentService(PaymentRepository payments, PaymentAuditRepository audit, PaymentMapper mapper,
            PaymentStateMachine stateMachine, ObjectMapper objectMapper, IdempotencyService idempotency) {
        this.payments = payments;
        this.audit = audit;
        this.mapper = mapper;
        this.stateMachine = stateMachine;
        this.objectMapper = objectMapper;
        this.idempotency = idempotency;
    }

    /**
     * Create a payment exactly once. The idempotency key is the supplied {@code idempotencyKey}
     * (typically the {@code Idempotency-Key} header) or, failing that, the TMF {@code correlatorId}.
     * Retries and duplicate submissions with the same key replay the original result rather than
     * creating a second payment.
     */
    public IdempotentResult<Payment> create(PaymentCreate request, String idempotencyKey, String correlationId) {
        String key = resolveKey(idempotencyKey, request.getCorrelatorId());
        String requestHash = key == null ? null : idempotency.hash(request);
        return idempotency.execute(key, CREATE_OPERATION, requestHash, Payment.class,
                () -> doCreate(request, key, requestHash, correlationId));
    }

    private Payment doCreate(PaymentCreate request, String key, String requestHash, String correlationId) {
        PaymentEntity entity = mapper.toEntity(request);
        entity.setId(UUID.randomUUID().toString());
        stateMachine.initialize(entity, correlationId);

        // Preserve full TMF fidelity by storing the complete resource; queryable columns live
        // alongside it for indexing/reporting.
        Payment dto = objectMapper.convertValue(request, Payment.class);
        applyServerFields(dto, entity);
        entity.setDtoJson(objectMapper.writeValueAsString(dto));

        payments.save(entity);
        audit.save(new PaymentAudit("Payment", entity.getId(), "CREATE", null, correlationId));
        // Durable idempotency record committed atomically with the payment write.
        idempotency.recordCompletion(key, CREATE_OPERATION, requestHash,
                objectMapper.writeValueAsString(dto), 201);
        return dto;
    }

    private static String resolveKey(String idempotencyKey, String correlatorId) {
        if (idempotencyKey != null && !idempotencyKey.isBlank()) {
            return idempotencyKey.trim();
        }
        if (correlatorId != null && !correlatorId.isBlank()) {
            return correlatorId.trim();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Payment retrieve(String id) {
        return toResponse(payments.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", id)));
    }

    @Transactional(readOnly = true)
    public List<Payment> list(Integer offset, Integer limit) {
        return payments.findAll(toPageable(offset, limit)).map(this::toResponse).getContent();
    }

    private Payment toResponse(PaymentEntity entity) {
        Payment dto = entity.getDtoJson() != null
                ? objectMapper.readValue(entity.getDtoJson(), Payment.class)
                : mapper.toDto(entity);
        // Volatile fields always reflect the current persisted state, not the stored snapshot.
        applyServerFields(dto, entity);
        ensureRequiredRefs(dto, entity);
        return dto;
    }

    private void applyServerFields(Payment dto, PaymentEntity entity) {
        dto.setId(entity.getId());
        dto.setHref(HREF_PREFIX + entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setStatusDate(entity.getStatusDate());
        dto.setPaymentDate(entity.getPaymentDate());
    }

    private void ensureRequiredRefs(Payment dto, PaymentEntity entity) {
        if (dto.getAccount() == null && entity.getAccountId() != null) {
            dto.setAccount(new AccountRef(entity.getAccountId()));
        }
        if (dto.getPaymentMethod() == null && entity.getPaymentMethodId() != null) {
            dto.setPaymentMethod(new PaymentMethodRefOrValue().id(entity.getPaymentMethodId()));
        }
    }

    private Pageable toPageable(Integer offset, Integer limit) {
        int size = (limit == null || limit <= 0) ? DEFAULT_LIMIT : Math.min(limit, MAX_LIMIT);
        int start = (offset == null || offset < 0) ? 0 : offset;
        return PageRequest.of(start / size, size);
    }
}
