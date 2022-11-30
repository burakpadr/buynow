package com.padr.buynow.domain.core.user.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
    
    private static final String ERROR = "USER_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "User not found!";

    public UserNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
