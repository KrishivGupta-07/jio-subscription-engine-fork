package com.jio.subscription.payments.web;

import com.jio.payments.tmf676.model.Error;
import com.jio.subscription.payments.exception.PaymentApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Translates exceptions into the TMF error model (HTTP status + {@code code}/{@code reason}/
 * {@code message}). Keeps the API responses contract-compliant regardless of the failure source.
 */
@RestControllerAdvice
public class TmfErrorAdvice {

    private static final Logger log = LoggerFactory.getLogger(TmfErrorAdvice.class);

    @ExceptionHandler(PaymentApiException.class)
    public ResponseEntity<Error> handleDomain(PaymentApiException ex) {
        return build(ex.getStatus(), ex.getCode(), ex.getReason(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidation(MethodArgumentNotValidException ex) {
        String detail = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .reduce((a, b) -> a + "; " + b)
                .orElse("Request validation failed");
        return build(HttpStatus.BAD_REQUEST, "400", "Bad Request", detail);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleUnreadable(HttpMessageNotReadableException ex) {
        return build(HttpStatus.BAD_REQUEST, "400", "Bad Request", "Malformed request body");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgument(IllegalArgumentException ex) {
        return build(HttpStatus.BAD_REQUEST, "400", "Bad Request", ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleIntegrity(DataIntegrityViolationException ex) {
        return build(HttpStatus.CONFLICT, "409", "Conflict",
                "The request conflicts with the current state of a resource");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleUnexpected(Exception ex) {
        log.error("Unhandled exception", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Internal Server Error",
                "An unexpected error occurred");
    }

    private ResponseEntity<Error> build(HttpStatus status, String code, String reason, String message) {
        Error error = new Error(code, reason)
                .message(message)
                .status(String.valueOf(status.value()));
        return ResponseEntity.status(status).body(error);
    }
}
