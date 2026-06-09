package com.jio.subscription.payments.exception;

import org.springframework.http.HttpStatus;

/**
 * Base for domain errors that map directly onto the TMF error model. Carries the HTTP status plus
 * the application-specific {@code code} and {@code reason} surfaced in the response body.
 */
public class PaymentApiException extends RuntimeException {

    private final HttpStatus status;
    private final String code;
    private final String reason;

    protected PaymentApiException(HttpStatus status, String code, String reason, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
