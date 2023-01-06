package com.padr.buynow.outbound.iyzipay.client;

import com.iyzipay.Options;
import com.iyzipay.model.Cancel;
import com.iyzipay.model.Payment;
import com.iyzipay.model.Refund;
import com.padr.buynow.outbound.iyzipay.model.transaction.CancelCompletedPaymentTransactionModel;
import com.padr.buynow.outbound.iyzipay.model.transaction.CreatePaymentTransactionModel;
import com.padr.buynow.outbound.iyzipay.model.transaction.FindCompletedPaymentTransactionModel;
import com.padr.buynow.outbound.iyzipay.model.transaction.PayBackCompletedPaymentTransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentClient {

    private final Options options;

    public Payment find(FindCompletedPaymentTransactionModel transactionModel) {
        return Payment.retrieve(transactionModel.to(), options);
    }

    public Payment pay(CreatePaymentTransactionModel transactionModel) {
        return Payment.create(transactionModel.to(), options);
    }

    public Cancel cancel(CancelCompletedPaymentTransactionModel transactionModel) {
        return Cancel.create(transactionModel.to(), options);
    }

    public Refund payBack(PayBackCompletedPaymentTransactionModel transactionModel) {
        return Refund.create(transactionModel.to(), options);
    }
}
