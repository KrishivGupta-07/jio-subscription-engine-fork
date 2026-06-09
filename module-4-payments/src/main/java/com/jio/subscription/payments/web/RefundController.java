package com.jio.subscription.payments.web;

import com.jio.payments.tmf676.api.RefundApi;
import com.jio.payments.tmf676.model.Refund;
import com.jio.payments.tmf676.model.RefundCreate;
import com.jio.subscription.payments.service.RefundService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class RefundController implements RefundApi {

    private final RefundService service;
    private final ObjectMapper objectMapper;

    public RefundController(RefundService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<Refund> createRefund(RefundCreate refund) {
        Refund created = service.create(refund, RequestCorrelation.current());
        return ResponseEntity.created(URI.create(created.getHref())).body(created);
    }

    @Override
    public ResponseEntity<Refund> retrieveRefund(String id, @Nullable String fields) {
        Refund dto = service.retrieve(id);
        return ResponseEntity.ok(PartialResponse.apply(objectMapper, dto, fields, Refund.class));
    }

    @Override
    public ResponseEntity<List<Refund>> listRefund(@Nullable String fields, @Nullable Integer offset,
            @Nullable Integer limit) {
        List<Refund> page = service.list(offset, limit).stream()
                .map(r -> PartialResponse.apply(objectMapper, r, fields, Refund.class))
                .toList();
        return ResponseEntity.ok(page);
    }
}
