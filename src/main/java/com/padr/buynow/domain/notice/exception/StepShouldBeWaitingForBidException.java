package com.padr.buynow.domain.notice.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class StepShouldBeWaitingForBidException extends BaseException {
    
    private static final String ERROR = "STEP_SHOULD_BE_WAITING_FOR_BID_EXCEPTION";
    private static final String MESSAGE = "The auction step should be 'waiting for bid' to run this process!";

    public StepShouldBeWaitingForBidException() {
        super(ERROR, MESSAGE);
    }
}
