package com.padr.buynow.domain.notice.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class NoticeIsNotLiveException extends BaseException {
    
    private static final String ERROR = "NOTICE_IS_NOT_LIVE_EXCEPTION";
    private static final String MESSAGE = "Notice is not live!";

    public NoticeIsNotLiveException() {
        super(ERROR, MESSAGE);
    }
}
