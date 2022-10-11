package com.padr.buynow.domain.product.exception;

import com.padr.buynow.domain.common.exception.BaseException;

public class ProductTypeAttributeGroupAlreadyExistWithNameException extends BaseException {
    
    private static final String ERROR = "PRODUCT_TYPE_ATTRIBUTE_GROUP_ALREADY_EXIST_WITH_NAME_EXCEPTION";
    private static final String MESSAGE = "There is a product type attribute group associated with this name!";

    public ProductTypeAttributeGroupAlreadyExistWithNameException() {
        super(ERROR, MESSAGE);
    }
}
