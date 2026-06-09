package com.jio.subscription.payments.exception;

import com.jio.subscription.payments.statemachine.PaymentState;
import org.springframework.http.HttpStatus;

public class IllegalStateTransitionException extends PaymentApiException {

    public IllegalStateTransitionException(String paymentId, PaymentState from, PaymentState to) {
        super(HttpStatus.CONFLICT, "409", "Conflict",
                "Payment '" + paymentId + "' cannot transition from " + from + " to " + to);
    }
}
