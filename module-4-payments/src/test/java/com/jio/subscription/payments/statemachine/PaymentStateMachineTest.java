package com.jio.subscription.payments.statemachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jio.subscription.payments.domain.PaymentEntity;
import com.jio.subscription.payments.domain.PaymentStateTransition;
import com.jio.subscription.payments.exception.IllegalStateTransitionException;
import com.jio.subscription.payments.repository.PaymentStateTransitionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaymentStateMachineTest {

    @Mock
    private PaymentStateTransitionRepository transitions;

    @InjectMocks
    private PaymentStateMachine stateMachine;

    private PaymentEntity paymentWithStatus(String status) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId("pay-1");
        entity.setStatus(status);
        return entity;
    }

    @Test
    void initializeSetsInitiatedAndLogsTransition() {
        PaymentEntity entity = new PaymentEntity();
        entity.setId("pay-1");
        when(transitions.save(any())).thenAnswer(i -> i.getArgument(0));

        stateMachine.initialize(entity, "corr-1");

        assertThat(entity.getStatus()).isEqualTo(PaymentState.INITIATED.tmfStatus());
        assertThat(entity.getStatusDate()).isNotNull();
        ArgumentCaptor<PaymentStateTransition> captor = ArgumentCaptor.forClass(PaymentStateTransition.class);
        verify(transitions).save(captor.capture());
        assertThat(captor.getValue().getFromState()).isNull();
        assertThat(captor.getValue().getToState()).isEqualTo("initiated");
    }

    @Test
    void legalTransitionUpdatesStatusAndAppendsHistory() {
        PaymentEntity entity = paymentWithStatus(PaymentState.AUTHORIZED.tmfStatus());
        when(transitions.save(any())).thenAnswer(i -> i.getArgument(0));

        stateMachine.transition(entity, PaymentState.CAPTURED, "psp-capture", "corr-2");

        assertThat(entity.getStatus()).isEqualTo("captured");
        ArgumentCaptor<PaymentStateTransition> captor = ArgumentCaptor.forClass(PaymentStateTransition.class);
        verify(transitions).save(captor.capture());
        assertThat(captor.getValue().getFromState()).isEqualTo("authorized");
        assertThat(captor.getValue().getToState()).isEqualTo("captured");
    }

    @Test
    void illegalTransitionIsRejectedAndNotPersisted() {
        PaymentEntity entity = paymentWithStatus(PaymentState.CAPTURED.tmfStatus());

        assertThatThrownBy(() -> stateMachine.transition(entity, PaymentState.AUTHORIZED, "bad", "corr-3"))
                .isInstanceOf(IllegalStateTransitionException.class);

        assertThat(entity.getStatus()).isEqualTo("captured");
        verify(transitions, never()).save(any());
    }

    @Test
    void transitionFromTerminalStateIsRejected() {
        PaymentEntity entity = paymentWithStatus(PaymentState.REFUNDED.tmfStatus());

        assertThatThrownBy(() -> stateMachine.transition(entity, PaymentState.CAPTURED, "x", "c"))
                .isInstanceOf(IllegalStateTransitionException.class);
        verify(transitions, never()).save(any());
    }

    @Test
    void unknownPersistedStatusIsRejected() {
        PaymentEntity entity = paymentWithStatus("not-a-real-status");

        assertThatThrownBy(() -> stateMachine.transition(entity, PaymentState.AUTHORIZED, "x", "c"))
                .isInstanceOf(IllegalStateTransitionException.class);
    }

    @Test
    void terminalStatesHaveNoAllowedTargets() {
        assertThat(PaymentState.FAILED.isTerminal()).isTrue();
        assertThat(PaymentState.REFUNDED.isTerminal()).isTrue();
        assertThat(PaymentState.INITIATED.isTerminal()).isFalse();
        assertThat(PaymentState.INITIATED.canTransitionTo(PaymentState.AUTHORIZED)).isTrue();
        assertThat(PaymentState.INITIATED.canTransitionTo(PaymentState.REFUNDED)).isFalse();
    }
}
