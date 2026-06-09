package com.jio.subscription.payments.service;

/**
 * Outcome of an idempotent operation.
 *
 * @param value    the operation result (freshly produced or replayed from a prior request)
 * @param replayed {@code true} if this is a replay of a previously completed request
 */
public record IdempotentResult<T>(T value, boolean replayed) {
}
