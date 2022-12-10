package com.padr.buynow.domain.core.cart.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class CartNotFoundException extends BaseException {
    
    private static final String ERROR = "CART_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Cart not found!";

    public CartNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
