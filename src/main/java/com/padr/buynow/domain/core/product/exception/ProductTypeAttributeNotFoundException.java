package com.padr.buynow.domain.core.product.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class ProductTypeAttributeNotFoundException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_ATTRIBUTE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Attribute not found!";

    public ProductTypeAttributeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
