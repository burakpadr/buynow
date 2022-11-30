package com.padr.buynow.domain.core.address.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class CountryNotFoundException extends BaseException {
    
    private static final String ERROR = "COUNTRY_NOT_FOUND";
    private static final String MESSAGE = "Country not found!";

    public CountryNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
