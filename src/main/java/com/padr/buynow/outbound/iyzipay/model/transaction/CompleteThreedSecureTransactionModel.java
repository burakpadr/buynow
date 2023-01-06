package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.model.ThreedsPayment;
import com.iyzipay.request.CreateThreedsPaymentRequest;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompleteThreedSecureTransactionModel {

    private String locale;
    private String conversationId;
    private String paymentId;
    private String conversationData;

    public CreateThreedsPaymentRequest to() {
        CreateThreedsPaymentRequest request = new CreateThreedsPaymentRequest();

        request.setLocale(locale);
        request.setConversationId(conversationId);
        request.setPaymentId(paymentId);
        request.setConversationData(conversationData);

        return request;
    }
}
