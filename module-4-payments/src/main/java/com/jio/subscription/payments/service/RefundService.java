package com.jio.subscription.payments.service;

import com.jio.payments.tmf676.model.AccountRef;
import com.jio.payments.tmf676.model.PaymentMethodRefOrValue;
import com.jio.payments.tmf676.model.Refund;
import com.jio.payments.tmf676.model.RefundCreate;
import com.jio.subscription.payments.domain.PaymentAudit;
import com.jio.subscription.payments.domain.RefundEntity;
import com.jio.subscription.payments.exception.ResourceNotFoundException;
import com.jio.subscription.payments.mapper.RefundMapper;
import com.jio.subscription.payments.repository.PaymentAuditRepository;
import com.jio.subscription.payments.repository.PaymentRepository;
import com.jio.subscription.payments.repository.RefundRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

/**
 * Basic refund persistence over TMF676. Full/partial refund validation against the originating
 * payment and state-machine integration are layered on in the dedicated refunds phase.
 */
@Service
public class RefundService {

    static final String HREF_PREFIX = "/refund/";
    private static final int DEFAULT_LIMIT = 20;
    private static final int MAX_LIMIT = 100;
    private static final String INITIAL_STATUS = "initiated";

    private final RefundRepository refunds;
    private final PaymentRepository payments;
    private final PaymentAuditRepository audit;
    private final RefundMapper mapper;
    private final ObjectMapper objectMapper;

    public RefundService(RefundRepository refunds, PaymentRepository payments, PaymentAuditRepository audit,
            RefundMapper mapper, ObjectMapper objectMapper) {
        this.refunds = refunds;
        this.payments = payments;
        this.audit = audit;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Refund create(RefundCreate request, String correlationId) {
        RefundEntity entity = mapper.toEntity(request);
        if (entity.getPaymentId() != null && !payments.existsById(entity.getPaymentId())) {
            throw new ResourceNotFoundException("Payment", entity.getPaymentId());
        }
        entity.setId(UUID.randomUUID().toString());
        entity.setStatus(INITIAL_STATUS);
        entity.setStatusDate(OffsetDateTime.now());

        Refund dto = objectMapper.convertValue(request, Refund.class);
        applyServerFields(dto, entity);
        entity.setDtoJson(objectMapper.writeValueAsString(dto));

        refunds.save(entity);
        audit.save(new PaymentAudit("Refund", entity.getId(), "CREATE", null, correlationId));
        return dto;
    }

    @Transactional(readOnly = true)
    public Refund retrieve(String id) {
        return toResponse(refunds.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Refund", id)));
    }

    @Transactional(readOnly = true)
    public List<Refund> list(Integer offset, Integer limit) {
        return refunds.findAll(toPageable(offset, limit)).map(this::toResponse).getContent();
    }

    private Refund toResponse(RefundEntity entity) {
        Refund dto = entity.getDtoJson() != null
                ? objectMapper.readValue(entity.getDtoJson(), Refund.class)
                : mapper.toDto(entity);
        applyServerFields(dto, entity);
        if (dto.getAccount() == null && entity.getAccountId() != null) {
            dto.setAccount(new AccountRef(entity.getAccountId()));
        }
        if (dto.getPaymentMethod() == null && entity.getPaymentMethodId() != null) {
            dto.setPaymentMethod(new PaymentMethodRefOrValue().id(entity.getPaymentMethodId()));
        }
        return dto;
    }

    private void applyServerFields(Refund dto, RefundEntity entity) {
        dto.setId(entity.getId());
        dto.setHref(HREF_PREFIX + entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setStatusDate(entity.getStatusDate());
        dto.setRefundDate(entity.getRefundDate());
    }

    private Pageable toPageable(Integer offset, Integer limit) {
        int size = (limit == null || limit <= 0) ? DEFAULT_LIMIT : Math.min(limit, MAX_LIMIT);
        int start = (offset == null || offset < 0) ? 0 : offset;
        return PageRequest.of(start / size, size);
    }
}
