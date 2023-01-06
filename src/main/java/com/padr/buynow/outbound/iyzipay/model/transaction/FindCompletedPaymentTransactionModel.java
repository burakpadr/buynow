package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.request.RetrievePaymentRequest;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FindCompletedPaymentTransactionModel {

    private String locale;
    private String conversationId;
    private String paymentConversationId;
    private String paymentId;

    public RetrievePaymentRequest to() {
        RetrievePaymentRequest request = new RetrievePaymentRequest();

        request.setLocale(locale);
        request.setConversationId(conversationId);
        request.setPaymentConversationId(paymentConversationId);
        request.setPaymentId(paymentId);

        return request;
    }
}
