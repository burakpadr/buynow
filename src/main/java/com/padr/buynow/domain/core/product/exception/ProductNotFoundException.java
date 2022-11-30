package com.padr.buynow.domain.core.product.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class ProductNotFoundException extends BaseException {
    
    private static final String ERROR = "PRODUCT_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Product not found!";

    public ProductNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
