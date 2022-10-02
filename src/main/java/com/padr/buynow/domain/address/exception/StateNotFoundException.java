package com.padr.buynow.domain.address.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class StateNotFoundException extends BaseException {
    
    private static final String ERROR = "STATE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "State not found!";

    public StateNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
