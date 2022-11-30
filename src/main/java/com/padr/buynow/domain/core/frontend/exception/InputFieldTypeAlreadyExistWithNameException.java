package com.padr.buynow.domain.core.frontend.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class InputFieldTypeAlreadyExistWithNameException extends BaseException {
    
    private static final String ERROR = "INPUT_FIELD_TYPE_ALREADY_EXIST_WITH_NAME_EXCEPTION";
    private static final String MESSAGE = "There is an input field type associated with this name!";

    public InputFieldTypeAlreadyExistWithNameException() {
        super(ERROR, MESSAGE);
    }
}
