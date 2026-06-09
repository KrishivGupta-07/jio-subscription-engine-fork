package com.jio.subscription.payments.exception;

import org.springframework.http.HttpStatus;

/** Raised when an idempotency key is reused with a different payload, or is concurrently in flight. */
public class IdempotencyConflictException extends PaymentApiException {

    public IdempotencyConflictException(String message) {
        super(HttpStatus.CONFLICT, "409", "Conflict", message);
    }
}
