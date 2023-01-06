package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.request.CreateCancelRequest;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CancelCompletedPaymentTransactionModel {

    private String locale;
    private String conversationId;
    private String paymentId;
    private String ip;

    public CreateCancelRequest to() {
        CreateCancelRequest request = new CreateCancelRequest();

        request.setLocale(locale);
        request.setConversationId(conversationId);
        request.setPaymentId(paymentId);
        request.setIp(ip);

        return request;
    }
}
