package com.jio.subscription.payments.statemachine;

import com.jio.subscription.payments.domain.PaymentEntity;
import com.jio.subscription.payments.domain.PaymentStateTransition;
import com.jio.subscription.payments.exception.IllegalStateTransitionException;
import com.jio.subscription.payments.repository.PaymentStateTransitionRepository;
import java.time.OffsetDateTime;
import org.springframework.stereotype.Component;

/**
 * Guards and records payment lifecycle transitions. Every accepted transition is written to the
 * append-only {@code payment_state_transition} table so the history survives crashes and is
 * auditable. Illegal transitions are rejected with a 409-mapped exception and never persisted.
 */
@Component
public class PaymentStateMachine {

    private final PaymentStateTransitionRepository transitions;

    public PaymentStateMachine(PaymentStateTransitionRepository transitions) {
        this.transitions = transitions;
    }

    /** Establish the initial {@link PaymentState#INITIATED} state for a brand-new payment. */
    public void initialize(PaymentEntity payment, String correlationId) {
        payment.setStatus(PaymentState.INITIATED.tmfStatus());
        payment.setStatusDate(OffsetDateTime.now());
        transitions.save(new PaymentStateTransition(
                payment.getId(), null, PaymentState.INITIATED.tmfStatus(), "created", correlationId));
    }

    /**
     * Move {@code payment} to {@code target}, rejecting illegal transitions. On success the entity's
     * status/statusDate are updated and a transition row is appended. The caller is responsible for
     * persisting the mutated entity within the same transaction.
     */
    public void transition(PaymentEntity payment, PaymentState target, String reason, String correlationId) {
        PaymentState current = PaymentState.fromTmfStatus(payment.getStatus())
                .orElseThrow(() -> new IllegalStateTransitionException(payment.getId(), null, target));
        if (!current.canTransitionTo(target)) {
            throw new IllegalStateTransitionException(payment.getId(), current, target);
        }
        payment.setStatus(target.tmfStatus());
        payment.setStatusDate(OffsetDateTime.now());
        transitions.save(new PaymentStateTransition(
                payment.getId(), current.tmfStatus(), target.tmfStatus(), reason, correlationId));
    }

    public PaymentState current(PaymentEntity payment) {
        return PaymentState.fromTmfStatus(payment.getStatus()).orElse(null);
    }
}
