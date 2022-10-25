package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AttributeValueNotFoundException extends BaseException {
    
    private static final String ERROR = "ATTRIBUTE_VALUE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Attribute value not found!";

    public AttributeValueNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
