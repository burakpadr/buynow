package com.padr.buynow.domain.core.product.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class ProductAttributeNotFoundException extends BaseException {

    private static final String ERROR = "PRODUCT_ATTRIBUTE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Product attribute not found!";

    public ProductAttributeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
