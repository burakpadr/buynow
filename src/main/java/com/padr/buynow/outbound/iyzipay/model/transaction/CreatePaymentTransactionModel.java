package com.padr.buynow.outbound.iyzipay.model.transaction;

import com.iyzipay.model.*;
import com.iyzipay.request.CreatePaymentRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class CreatePaymentTransactionModel {

    private String locale;
    private String conversationId;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private Currency currency;
    private Integer installment;
    private PaymentChannel paymentChannel;
    private String callbackUrl;
    private PaymentCard paymentCard;
    private Buyer buyer;
    private Address shippingAddress;
    private Address billingAddress;
    private List<BasketItem> basketItems;

    public CreatePaymentRequest to() {
        CreatePaymentRequest request = new CreatePaymentRequest();

        request.setLocale(locale);
        request.setConversationId(conversationId);
        request.setPrice(price);
        request.setPaidPrice(paidPrice);
        request.setCurrency(currency.name());
        request.setInstallment(installment);
        request.setPaymentChannel(paymentChannel.name());
        request.setCallbackUrl(callbackUrl);
        request.setPaymentCard(paymentCard);
        request.setBuyer(buyer);
        request.setShippingAddress(shippingAddress);
        request.setBillingAddress(billingAddress);
        request.setBasketItems(basketItems);

        return request;
    }
}
