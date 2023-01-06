package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.request.RetrieveInstallmentInfoRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FindInstallmentTransactionModel {

    private String locale;
    private String binNumber;
    private String conversationId;
    private BigDecimal price;

    public RetrieveInstallmentInfoRequest to() {
        RetrieveInstallmentInfoRequest request = new RetrieveInstallmentInfoRequest();

        request.setLocale(locale);
        request.setBinNumber(binNumber);
        request.setConversationId(conversationId);
        request.setPrice(price);

        return request;
    }
}
