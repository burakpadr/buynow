package com.padr.buynow.domain.core.product.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class ProductTypeAttributeAlreadyExistWithNameException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_ATTRIBUTE_ALREADY_EXIST_WITH_NAME_EXCEPTION";
    private static final String MESSAGE = "There is an attribute associated with this name!";

    public ProductTypeAttributeAlreadyExistWithNameException() {
        super(ERROR, MESSAGE);
    }
}
