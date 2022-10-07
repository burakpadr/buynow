package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class ProductTypeNotFoundException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Product type not found!";

    public ProductTypeNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
