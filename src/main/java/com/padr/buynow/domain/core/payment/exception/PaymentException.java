package com.padr.buynow.domain.core.payment.exception;

import com.padr.buynow.domain.core.common.exception.BaseException;

public class PaymentException extends BaseException {

    private static final String ERROR = "PAYMENT_EXCEPTION";
    private static final String DEFAULT_MESSAGE = "There was a problem with the payment mechanism";

    public PaymentException() {
        super(ERROR, DEFAULT_MESSAGE);
    }

    public PaymentException(String message) {
        super(ERROR, message);
    }
}
