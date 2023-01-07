package com.padr.buynow.outbound.iyzipay.port;

import com.iyzipay.model.*;
import com.padr.buynow.outbound.iyzipay.client.InstallmentClient;
import com.padr.buynow.outbound.iyzipay.client.PaymentClient;
import com.padr.buynow.outbound.iyzipay.client.ThreedSecureClient;
import com.padr.buynow.outbound.iyzipay.model.transaction.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IyzipayClientPortImpl implements IyzipayClientPort {

    private final InstallmentClient installmentClient;
    private final PaymentClient paymentClient;
    private ThreedSecureClient threedSecureClient;

    @Override
    public InstallmentInfo findInstallment(FindInstallmentTransactionModel transactionModel) {
        return installmentClient.findInstallment(transactionModel);
    }

    @Override
    public Payment findPayment(FindCompletedPaymentTransactionModel transactionModel) {
        return paymentClient.find(transactionModel);
    }

    @Override
    public Payment pay(CreatePaymentTransactionModel transactionModel) {
        return paymentClient.pay(transactionModel);
    }

    @Override
    public Cancel cancelPayment(CancelCompletedPaymentTransactionModel transactionModel) {
        return paymentClient.cancel(transactionModel);
    }

    @Override
    public Refund payBack(PayBackCompletedPaymentTransactionModel transactionModel) {
        return paymentClient.payBack(transactionModel);
    }

    @Override
    public ThreedsInitialize initializeThreedSecure(CreatePaymentTransactionModel transactionModel) {
        return threedSecureClient.initialize(transactionModel);
    }

    @Override
    public ThreedsPayment completeThreedSecure(CompleteThreedSecureTransactionModel transactionModel) {
        return threedSecureClient.complete(transactionModel);
    }
}
