package com.jio.subscription.payments.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends PaymentApiException {

    public InvalidRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, "400", "Bad Request", message);
    }
}
