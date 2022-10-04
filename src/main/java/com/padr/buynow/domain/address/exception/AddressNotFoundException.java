package com.padr.buynow.domain.address.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AddressNotFoundException extends BaseException {

    private static final String ERROR = "ADDRESS_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Address not found!";

    public AddressNotFoundException() {
        super(ERROR, MESSAGE);
    }
    
}
