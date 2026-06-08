package org.openapitools.api;

import org.openapitools.model.Error;
import org.openapitools.model.ProductOrder;
import org.openapitools.model.ProductOrderCreate;
import org.openapitools.model.ProductOrderStateType;
import org.openapitools.model.ProductOrderUpdate;
import org.openapitools.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.lang.Nullable;

import jakarta.validation.Valid;
import jakarta.annotation.Generated;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
@Controller
@RequestMapping("${openapi.productOrdering.base-path:/tmf-api/productOrderingManagement/v4}")
public class ProductOrderApiController implements ProductOrderApi {

    private final NativeWebRequest request;
    private final ProductOrderRepository repository;

    @Autowired
    public ProductOrderApiController(NativeWebRequest request, ProductOrderRepository repository) {
        this.request = request;
        this.repository = repository;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ProductOrder> createProductOrder(
            @Valid @RequestBody ProductOrderCreate productOrder) {
        ProductOrder order = new ProductOrder(productOrder.getProductOrderItem());
        order.setCancellationDate(productOrder.getCancellationDate());
        order.setCancellationReason(productOrder.getCancellationReason());
        order.setCategory(productOrder.getCategory());
        order.setDescription(productOrder.getDescription());
        order.setExternalId(productOrder.getExternalId());
        order.setNotificationContact(productOrder.getNotificationContact());
        order.setPriority(productOrder.getPriority());
        order.setRequestedCompletionDate(productOrder.getRequestedCompletionDate());
        order.setRequestedStartDate(productOrder.getRequestedStartDate());
        order.setAgreement(productOrder.getAgreement());
        order.setBillingAccount(productOrder.getBillingAccount());
        order.setChannel(productOrder.getChannel());
        order.setNote(productOrder.getNote());
        order.setOrderTotalPrice(productOrder.getOrderTotalPrice());
        order.setPayment(productOrder.getPayment());
        order.setProductOfferingQualification(productOrder.getProductOfferingQualification());
        order.setQuote(productOrder.getQuote());
        order.setRelatedParty(productOrder.getRelatedParty());
        order.setAtBaseType(productOrder.getAtBaseType());
        order.setAtSchemaLocation(productOrder.getAtSchemaLocation());
        order.setAtType(productOrder.getAtType());
        order.setOrderDate(OffsetDateTime.now());
        order.setState(ProductOrderStateType.ACKNOWLEDGED);

        ProductOrder saved = repository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<List<ProductOrder>> listProductOrder(
            @Valid @RequestParam(value = "fields", required = false) @Nullable String fields,
            @Valid @RequestParam(value = "offset", required = false) @Nullable Integer offset,
            @Valid @RequestParam(value = "limit", required = false) @Nullable Integer limit) {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(
            @PathVariable("id") String id,
            @Valid @RequestParam(value = "fields", required = false) @Nullable String fields) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ProductOrder> patchProductOrder(
            @PathVariable("id") String id,
            @Valid @RequestBody org.openapitools.model.ProductOrderUpdate productOrder) {
        return repository.findById(id).map(existing -> {
            if (productOrder.getCancellationDate() != null)       existing.setCancellationDate(productOrder.getCancellationDate());
            if (productOrder.getCancellationReason() != null)     existing.setCancellationReason(productOrder.getCancellationReason());
            if (productOrder.getCategory() != null)               existing.setCategory(productOrder.getCategory());
            if (productOrder.getCompletionDate() != null)         existing.setCompletionDate(productOrder.getCompletionDate());
            if (productOrder.getDescription() != null)            existing.setDescription(productOrder.getDescription());
            if (productOrder.getExpectedCompletionDate() != null) existing.setExpectedCompletionDate(productOrder.getExpectedCompletionDate());
            if (productOrder.getExternalId() != null)             existing.setExternalId(productOrder.getExternalId());
            if (productOrder.getNotificationContact() != null)    existing.setNotificationContact(productOrder.getNotificationContact());
            if (productOrder.getPriority() != null)               existing.setPriority(productOrder.getPriority());
            if (productOrder.getRequestedCompletionDate() != null) existing.setRequestedCompletionDate(productOrder.getRequestedCompletionDate());
            if (productOrder.getRequestedStartDate() != null)     existing.setRequestedStartDate(productOrder.getRequestedStartDate());
            if (productOrder.getState() != null)                  existing.setState(productOrder.getState());
            if (productOrder.getAtBaseType() != null)             existing.setAtBaseType(productOrder.getAtBaseType());
            if (productOrder.getAtType() != null)                 existing.setAtType(productOrder.getAtType());
            if (!productOrder.getAgreement().isEmpty())           existing.setAgreement(productOrder.getAgreement());
            if (!productOrder.getChannel().isEmpty())             existing.setChannel(productOrder.getChannel());
            if (!productOrder.getNote().isEmpty())                existing.setNote(productOrder.getNote());
            if (!productOrder.getOrderTotalPrice().isEmpty())     existing.setOrderTotalPrice(productOrder.getOrderTotalPrice());
            if (!productOrder.getPayment().isEmpty())             existing.setPayment(productOrder.getPayment());
            if (!productOrder.getProductOfferingQualification().isEmpty()) existing.setProductOfferingQualification(productOrder.getProductOfferingQualification());
            if (!productOrder.getProductOrderItem().isEmpty())    existing.setProductOrderItem(productOrder.getProductOrderItem());
            if (!productOrder.getQuote().isEmpty())               existing.setQuote(productOrder.getQuote());
            if (!productOrder.getRelatedParty().isEmpty())        existing.setRelatedParty(productOrder.getRelatedParty());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteProductOrder(
            @PathVariable("id") String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
