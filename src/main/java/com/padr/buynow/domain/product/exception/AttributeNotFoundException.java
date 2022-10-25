package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AttributeNotFoundException extends BaseException {
    
    private static final String ERROR = "ATTRIBUTE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Attribute not found!";

    public AttributeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
