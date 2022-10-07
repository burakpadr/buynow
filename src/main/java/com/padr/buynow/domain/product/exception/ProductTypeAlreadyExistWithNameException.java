package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class ProductTypeAlreadyExistWithNameException extends BaseException {

    private static final String ERROR = "PRODUCT_TYPE_ALREADY_EXIST_WITH_NAME_EXCEPTION";
    private static final String MESSAGE = "There is a product type associated with this name!";

    public ProductTypeAlreadyExistWithNameException() {
        super(ERROR, MESSAGE);
    }
}
