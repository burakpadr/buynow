package com.padr.buynow.domain.core.notice.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class DiscountNotFoundException extends BaseException {
    
    private static final String ERROR = "DISCOUNT_NOT_FOUND_EXCEPTION";
    private static final String MESSAGE = "Discount not found!";

    public DiscountNotFoundException() {
        super(ERROR, MESSAGE);
    }
}
