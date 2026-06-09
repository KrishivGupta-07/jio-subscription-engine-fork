package com.jio.subscription.payments.web;

import java.util.UUID;
import org.slf4j.MDC;

/** Resolves a correlation id for the current request, falling back to a fresh UUID. */
public final class RequestCorrelation {

    public static final String MDC_KEY = "correlationId";

    private RequestCorrelation() {
    }

    public static String current() {
        String id = MDC.get(MDC_KEY);
        return (id != null && !id.isBlank()) ? id : UUID.randomUUID().toString();
    }
}
