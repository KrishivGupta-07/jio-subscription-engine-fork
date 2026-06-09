package com.jio.subscription.payments.statemachine;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Internal payment lifecycle. The {@link #tmfStatus} value is what we serialise into the free-form
 * TMF676 {@code Payment.status} field; everything else (allowed transitions, terminality) is
 * enforced internally and never leaks the richer model to the API contract.
 */
public enum PaymentState {

    INITIATED("initiated"),
    AUTHORIZED("authorized"),
    CAPTURED("captured"),
    SETTLED("settled"),
    FAILED("failed"),
    PARTIALLY_REFUNDED("partiallyRefunded"),
    REFUNDED("refunded");

    private final String tmfStatus;

    PaymentState(String tmfStatus) {
        this.tmfStatus = tmfStatus;
    }

    public String tmfStatus() {
        return tmfStatus;
    }

    private static final Map<PaymentState, Set<PaymentState>> TRANSITIONS = new EnumMap<>(PaymentState.class);

    static {
        TRANSITIONS.put(INITIATED, EnumSet.of(AUTHORIZED, CAPTURED, FAILED));
        TRANSITIONS.put(AUTHORIZED, EnumSet.of(CAPTURED, FAILED));
        TRANSITIONS.put(CAPTURED, EnumSet.of(SETTLED, PARTIALLY_REFUNDED, REFUNDED));
        TRANSITIONS.put(SETTLED, EnumSet.of(PARTIALLY_REFUNDED, REFUNDED));
        TRANSITIONS.put(PARTIALLY_REFUNDED, EnumSet.of(PARTIALLY_REFUNDED, REFUNDED));
        TRANSITIONS.put(FAILED, EnumSet.noneOf(PaymentState.class));
        TRANSITIONS.put(REFUNDED, EnumSet.noneOf(PaymentState.class));
    }

    public boolean canTransitionTo(PaymentState target) {
        return TRANSITIONS.getOrDefault(this, Collections.emptySet()).contains(target);
    }

    public Set<PaymentState> allowedTargets() {
        return Collections.unmodifiableSet(TRANSITIONS.getOrDefault(this, Collections.emptySet()));
    }

    public boolean isTerminal() {
        return TRANSITIONS.getOrDefault(this, Collections.emptySet()).isEmpty();
    }

    /** Resolve from the persisted TMF status string. */
    public static Optional<PaymentState> fromTmfStatus(String status) {
        if (status == null) {
            return Optional.empty();
        }
        return Arrays.stream(values()).filter(s -> s.tmfStatus.equals(status)).findFirst();
    }
}
