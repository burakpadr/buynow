package com.padr.buynow.domain.attribute.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class AttributeAlreadyExistWithNameException extends BaseException {
    
    private static final String ERROR = "ATTRIBUTE_ALREADY_EXIST_WITH_NAME_EXCEPTION";
    private static final String MESSAGE = "There is an attribute associated with this name!";

    public AttributeAlreadyExistWithNameException() {
        super(ERROR, MESSAGE);
    }
}
