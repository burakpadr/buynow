package com.padr.buynow.domain.notice.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AuctionHasAlreadyStartedException extends BaseException {
    
    private static final String ERROR = "AUCTION_HAS_ALREADY_STARTED_EXCEPTION";
    private static final String MESSAGE = "The auction must haven't started to run this process!";

    public AuctionHasAlreadyStartedException() {
        super(ERROR, MESSAGE);
    }
}
