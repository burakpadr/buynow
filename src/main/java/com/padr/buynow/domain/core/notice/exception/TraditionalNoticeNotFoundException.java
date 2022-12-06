package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class TraditionalNoticeNotFoundException extends BaseException {
    
    private static final String ERROR = "TRADITIONAL_NOTICE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Traditional notice not found!";

    public TraditionalNoticeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
