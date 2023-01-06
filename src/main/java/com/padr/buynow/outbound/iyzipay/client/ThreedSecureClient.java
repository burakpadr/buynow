package com.padr.buynow.outbound.iyzipay.client;

import com.iyzipay.Options;
import com.iyzipay.model.ThreedsInitialize;
import com.iyzipay.model.ThreedsPayment;
import com.padr.buynow.outbound.iyzipay.model.transaction.CompleteThreedSecureTransactionModel;
import com.padr.buynow.outbound.iyzipay.model.transaction.CreatePaymentTransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ThreedSecureClient {

    private final Options options;

    public ThreedsInitialize initialize(CreatePaymentTransactionModel transactionModel) {
        return ThreedsInitialize.create(transactionModel.to(), options);
    }

    public ThreedsPayment complete(CompleteThreedSecureTransactionModel transactionModel) {
        return ThreedsPayment.create(transactionModel.to(), options);
    }
}
