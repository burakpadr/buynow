package com.padr.buynow.domain.core.frontend.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class InputFieldTypeNotFoundException extends BaseException {
    
    private static final String ERROR = "INPUT_FIELD_TYPE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Input field type not found!";

    public InputFieldTypeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
