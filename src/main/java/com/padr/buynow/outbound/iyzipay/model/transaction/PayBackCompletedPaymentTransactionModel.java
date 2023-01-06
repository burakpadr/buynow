package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.request.CreateRefundRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PayBackCompletedPaymentTransactionModel {

    private String locale;
    private String conversationId;
    private BigDecimal price;
    private String paymentTransactionId;
    private String ip;

    public CreateRefundRequest to() {
        CreateRefundRequest request = new CreateRefundRequest();

        request.setLocale(locale);
        request.setConversationId(conversationId);
        request.setPrice(price);
        request.setPaymentTransactionId(paymentTransactionId);
        request.setIp(ip);

        return request;
    }
}
