package org.openapitools.api;

import org.openapitools.model.CancelProductOrderCreateEvent;
import org.openapitools.model.CancelProductOrderInformationRequiredEvent;
import org.openapitools.model.CancelProductOrderStateChangeEvent;
import org.openapitools.model.Error;
import org.openapitools.model.EventSubscription;
import org.openapitools.model.ProductOrderAttributeValueChangeEvent;
import org.openapitools.model.ProductOrderCreateEvent;
import org.openapitools.model.ProductOrderDeleteEvent;
import org.openapitools.model.ProductOrderInformationRequiredEvent;
import org.openapitools.model.ProductOrderStateChangeEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
@Controller
@RequestMapping("${openapi.productOrdering.base-path:/tmf-api/productOrderingManagement/v4}")
public class ListenerApiController implements ListenerApi {

    private final NativeWebRequest request;

    @Autowired
    public ListenerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
