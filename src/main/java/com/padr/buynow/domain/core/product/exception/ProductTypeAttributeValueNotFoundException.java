package com.padr.buynow.domain.core.product.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class ProductTypeAttributeValueNotFoundException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_ATTRIBUTE_VALUE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Attribute value not found!";

    public ProductTypeAttributeValueNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
