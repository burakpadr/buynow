package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class StepShouldBePreparingCargoException extends BaseException {

    private static final String ERROR = "STEP_SHOULD_BE_PREPARING_CARGO_EXCEPTION";
    private static final String MESSAGE = "The auction step should be 'preparing cargo' to run this process!";

    public StepShouldBePreparingCargoException() {
        super(ERROR, MESSAGE);
    }
}
