package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class BidNotFoundException extends BaseException {
    
    private static final String ERROR = "BID_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Bid not found!";

    public BidNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
