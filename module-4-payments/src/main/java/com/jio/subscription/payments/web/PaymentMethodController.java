package com.jio.subscription.payments.web;

import com.jio.payments.tmf670.api.PaymentMethodApi;
import com.jio.payments.tmf670.model.PaymentMethod;
import com.jio.payments.tmf670.model.PaymentMethodCreate;
import com.jio.payments.tmf670.model.PaymentMethodUpdate;
import com.jio.subscription.payments.service.PaymentMethodService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class PaymentMethodController implements PaymentMethodApi {

    private final PaymentMethodService service;
    private final ObjectMapper objectMapper;

    public PaymentMethodController(PaymentMethodService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<PaymentMethod> createPaymentMethod(PaymentMethodCreate paymentMethod) {
        PaymentMethod created = service.create(paymentMethod, RequestCorrelation.current());
        return ResponseEntity.created(created.getHref()).body(created);
    }

    @Override
    public ResponseEntity<PaymentMethod> retrievePaymentMethod(String id, @Nullable String fields) {
        PaymentMethod dto = service.retrieve(id);
        return ResponseEntity.ok(PartialResponse.apply(objectMapper, dto, fields, PaymentMethod.class));
    }

    @Override
    public ResponseEntity<List<PaymentMethod>> listPaymentMethod(@Nullable String fields, @Nullable Integer offset,
            @Nullable Integer limit) {
        List<PaymentMethod> page = service.list(offset, limit).stream()
                .map(pm -> PartialResponse.apply(objectMapper, pm, fields, PaymentMethod.class))
                .toList();
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<PaymentMethod> patchPaymentMethod(String id, PaymentMethodUpdate paymentMethod) {
        PaymentMethod updated = service.patch(id, paymentMethod, RequestCorrelation.current());
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deletePaymentMethod(String id) {
        service.delete(id, RequestCorrelation.current());
        return ResponseEntity.noContent().build();
    }
}
