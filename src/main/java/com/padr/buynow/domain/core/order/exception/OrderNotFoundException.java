package com.padr.buynow.domain.core.order.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class OrderNotFoundException  extends BaseException{
    
    private static final String ERROR = "ORDER_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Order not found!";

    public OrderNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
