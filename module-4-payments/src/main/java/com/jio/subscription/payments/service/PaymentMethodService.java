package com.jio.subscription.payments.service;

import com.jio.payments.tmf670.model.PaymentMethod;
import com.jio.payments.tmf670.model.PaymentMethodCreate;
import com.jio.payments.tmf670.model.PaymentMethodUpdate;
import com.jio.subscription.payments.domain.PaymentAudit;
import com.jio.subscription.payments.domain.PaymentMethodEntity;
import com.jio.subscription.payments.exception.InvalidRequestException;
import com.jio.subscription.payments.exception.ResourceNotFoundException;
import com.jio.subscription.payments.mapper.PaymentMethodMapper;
import com.jio.subscription.payments.repository.PaymentAuditRepository;
import com.jio.subscription.payments.repository.PaymentMethodRepository;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class PaymentMethodService {

    static final String HREF_PREFIX = "/paymentMethod/";
    private static final int DEFAULT_LIMIT = 20;
    private static final int MAX_LIMIT = 100;

    private final PaymentMethodRepository methods;
    private final PaymentAuditRepository audit;
    private final PaymentMethodMapper mapper;
    private final ObjectMapper objectMapper;

    public PaymentMethodService(PaymentMethodRepository methods, PaymentAuditRepository audit,
            PaymentMethodMapper mapper, ObjectMapper objectMapper) {
        this.methods = methods;
        this.audit = audit;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public PaymentMethod create(PaymentMethodCreate request, String correlationId) {
        validateType(request.getAtType());
        PaymentMethodEntity entity = mapper.toEntity(request);
        entity.setId(UUID.randomUUID().toString());

        PaymentMethod dto = objectMapper.convertValue(request, PaymentMethod.class);
        applyServerFields(dto, entity);
        entity.setDtoJson(objectMapper.writeValueAsString(dto));

        methods.save(entity);
        audit.save(new PaymentAudit("PaymentMethod", entity.getId(), "CREATE", null, correlationId));
        return dto;
    }

    @Transactional(readOnly = true)
    public PaymentMethod retrieve(String id) {
        return toResponse(methods.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentMethod", id)));
    }

    @Transactional(readOnly = true)
    public List<PaymentMethod> list(Integer offset, Integer limit) {
        return methods.findAll(toPageable(offset, limit)).map(this::toResponse).getContent();
    }

    @Transactional
    public PaymentMethod patch(String id, PaymentMethodUpdate update, String correlationId) {
        PaymentMethodEntity entity = methods.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentMethod", id));

        PaymentMethod merged = mergePatch(toResponse(entity), update);
        applyMutableColumns(entity, merged);
        applyServerFields(merged, entity);
        entity.setDtoJson(objectMapper.writeValueAsString(merged));

        methods.save(entity);
        audit.save(new PaymentAudit("PaymentMethod", id, "PATCH", null, correlationId));
        return merged;
    }

    @Transactional
    public void delete(String id, String correlationId) {
        if (!methods.existsById(id)) {
            throw new ResourceNotFoundException("PaymentMethod", id);
        }
        methods.deleteById(id);
        audit.save(new PaymentAudit("PaymentMethod", id, "DELETE", null, correlationId));
    }

    private PaymentMethod mergePatch(PaymentMethod current, PaymentMethodUpdate update) {
        Map<String, Object> base = objectMapper.convertValue(current, Map.class);
        Map<String, Object> patch = objectMapper.convertValue(update, Map.class);
        patch.forEach((key, value) -> {
            if (value != null) {
                base.put(key, value);
            }
        });
        return objectMapper.convertValue(base, PaymentMethod.class);
    }

    private void applyMutableColumns(PaymentMethodEntity entity, PaymentMethod dto) {
        if (dto.getAtType() != null) {
            entity.setType(dto.getAtType().getValue());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        entity.setDescription(dto.getDescription());
        entity.setPreferred(dto.getIsPreferred());
        entity.setAuthorizationCode(dto.getAuthorizationCode());
        entity.setStatus(dto.getStatus());
        entity.setStatusReason(dto.getStatusReason());
        entity.setStatusDate(dto.getStatusDate());
    }

    private PaymentMethod toResponse(PaymentMethodEntity entity) {
        PaymentMethod dto = entity.getDtoJson() != null
                ? objectMapper.readValue(entity.getDtoJson(), PaymentMethod.class)
                : mapper.toDto(entity);
        applyServerFields(dto, entity);
        return dto;
    }

    private void applyServerFields(PaymentMethod dto, PaymentMethodEntity entity) {
        dto.setId(entity.getId());
        dto.setHref(URI.create(HREF_PREFIX + entity.getId()));
    }

    private void validateType(String type) {
        try {
            PaymentMethod.AtTypeEnum.fromValue(type);
        } catch (IllegalArgumentException ex) {
            throw new InvalidRequestException("Unsupported payment method @type: " + type);
        }
    }

    private Pageable toPageable(Integer offset, Integer limit) {
        int size = (limit == null || limit <= 0) ? DEFAULT_LIMIT : Math.min(limit, MAX_LIMIT);
        int start = (offset == null || offset < 0) ? 0 : offset;
        return PageRequest.of(start / size, size);
    }
}
