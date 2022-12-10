package com.padr.buynow.domain.core.cart.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class CartItemNotFoundException extends BaseException {
    
    private static final String ERROR = "CART_ITEM_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Cart item not found!";

    public CartItemNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
