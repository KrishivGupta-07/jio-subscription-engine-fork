package com.jio.subscription.payments.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** Reads the {@code Idempotency-Key} request header for the current request, if present. */
public final class IdempotencyKeys {

    public static final String HEADER = "Idempotency-Key";

    private IdempotencyKeys() {
    }

    public static String fromCurrentRequest() {
        if (RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes attrs) {
            String value = attrs.getRequest().getHeader(HEADER);
            if (value != null && !value.isBlank()) {
                return value.trim();
            }
        }
        return null;
    }
}
