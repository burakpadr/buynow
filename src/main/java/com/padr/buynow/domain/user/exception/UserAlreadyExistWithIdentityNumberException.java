package com.padr.buynow.domain.user.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class UserAlreadyExistWithIdentityNumberException extends BaseException {
    
    private static final String ERROR = "USER_ALREADY_EXIST_WITH_IDENTITY_NUMBER_EXCEPTION";
    private static final String MESSAGE = "There is a user associated with this identity number!";

    public UserAlreadyExistWithIdentityNumberException() {
        super(ERROR, MESSAGE);
    }
}
