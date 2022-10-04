package com.padr.buynow.domain.user.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class UserAlreadyExistWithEmailException extends BaseException {
    
    private static final String ERROR = "USER_ALREADY_EXIST_WITH_EMAIL_EXCEPTION";
    private static final String MESSAGE = "There is a user associated with this email!";

    public UserAlreadyExistWithEmailException() {
        super(ERROR, MESSAGE);
    }
}
