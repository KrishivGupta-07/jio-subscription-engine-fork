package com.jio.subscription.payments.web;

import com.jio.payments.tmf676.api.PaymentApi;
import com.jio.payments.tmf676.model.Payment;
import com.jio.payments.tmf676.model.PaymentCreate;
import com.jio.subscription.payments.service.IdempotentResult;
import com.jio.subscription.payments.service.PaymentService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class PaymentController implements PaymentApi {

    private final PaymentService service;
    private final ObjectMapper objectMapper;

    public PaymentController(PaymentService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<Payment> createPayment(PaymentCreate payment) {
        IdempotentResult<Payment> result =
                service.create(payment, IdempotencyKeys.fromCurrentRequest(), RequestCorrelation.current());
        Payment created = result.value();
        URI location = URI.create(created.getHref());
        // Replays return 200 with the original resource; the first request returns 201 Created.
        return result.replayed()
                ? ResponseEntity.ok().location(location).body(created)
                : ResponseEntity.created(location).body(created);
    }

    @Override
    public ResponseEntity<Payment> retrievePayment(String id, @Nullable String fields) {
        Payment dto = service.retrieve(id);
        return ResponseEntity.ok(PartialResponse.apply(objectMapper, dto, fields, Payment.class));
    }

    @Override
    public ResponseEntity<List<Payment>> listPayment(@Nullable String fields, @Nullable Integer offset,
            @Nullable Integer limit) {
        List<Payment> page = service.list(offset, limit).stream()
                .map(p -> PartialResponse.apply(objectMapper, p, fields, Payment.class))
                .toList();
        return ResponseEntity.ok(page);
    }
}
