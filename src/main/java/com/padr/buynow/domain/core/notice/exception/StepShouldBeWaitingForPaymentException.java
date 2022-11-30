package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class StepShouldBeWaitingForPaymentException extends BaseException {
    
    private static final String ERROR = "STEP_SHOULD_BE_WAITING_FOR_PAYMENT_EXCEPTION";
    private static final String MESSAGE = "The auction step should be 'waiting for payment' to run this process!";

    public StepShouldBeWaitingForPaymentException() {
        super(ERROR, MESSAGE);
    }
}
