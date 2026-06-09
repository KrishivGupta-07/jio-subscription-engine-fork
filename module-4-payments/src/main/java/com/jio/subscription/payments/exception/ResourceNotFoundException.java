package com.jio.subscription.payments.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends PaymentApiException {

    public ResourceNotFoundException(String resource, String id) {
        super(HttpStatus.NOT_FOUND, "404", "Not Found", resource + " '" + id + "' was not found");
    }
}
