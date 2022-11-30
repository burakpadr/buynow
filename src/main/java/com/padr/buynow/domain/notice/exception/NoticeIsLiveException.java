package com.padr.buynow.domain.notice.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class NoticeIsLiveException extends BaseException {
    
    private static final String ERROR = "NOTICE_IS_LIVE_EXCEPTION";
    private static final String MESSAGE = "Notice is live!";

    public NoticeIsLiveException() {
        super(ERROR, MESSAGE);
    }
}