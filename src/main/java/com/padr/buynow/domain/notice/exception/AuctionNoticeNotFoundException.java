package com.padr.buynow.domain.notice.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AuctionNoticeNotFoundException extends BaseException {

    private static final String ERROR = "AUCTION_NOTICE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Auction notice not found!";

    public AuctionNoticeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
