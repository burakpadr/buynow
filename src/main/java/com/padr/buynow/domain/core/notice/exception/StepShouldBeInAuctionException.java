package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class StepShouldBeInAuctionException extends BaseException {
    
    private static final String ERROR = "STEP_SHOULD_BE_IN_ACTUON_EXCEPTION";
    private static final String MESSAGE = "The auction step should be 'in notice' to run this process";

    public StepShouldBeInAuctionException() {
        super(ERROR, MESSAGE);
    }
}
