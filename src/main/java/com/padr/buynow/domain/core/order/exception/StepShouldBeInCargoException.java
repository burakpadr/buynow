package com.padr.buynow.domain.core.order.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class StepShouldBeInCargoException extends BaseException {

    private static final String ERROR = "STEP_SHOULD_BE_IN_CARGO_EXCEPTION";
    private static final String MESSAGE = "The order step should be 'in cargo' to run this process!";

    public StepShouldBeInCargoException() {
        super(ERROR, MESSAGE);
    }
}
