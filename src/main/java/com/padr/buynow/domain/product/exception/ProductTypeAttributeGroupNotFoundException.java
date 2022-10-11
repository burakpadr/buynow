package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class ProductTypeAttributeGroupNotFoundException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_ATTRIBUTE_GROUP_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Product type attribute group not found!";

    public ProductTypeAttributeGroupNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
