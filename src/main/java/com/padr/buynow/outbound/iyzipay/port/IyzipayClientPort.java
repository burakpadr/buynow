package com.padr.buynow.outbound.iyzipay.port;

import com.iyzipay.model.*;
import com.padr.buynow.outbound.iyzipay.model.transaction.*;

public interface IyzipayClientPort {

    InstallmentInfo findInstallment(FindInstallmentTransactionModel transactionModel);

    Payment findPayment(FindCompletedPaymentTransactionModel transactionModel);

    Payment pay(CreatePaymentTransactionModel transactionModel);

    Cancel cancelPayment(CancelCompletedPaymentTransactionModel transactionModel);

    Refund payBack(PayBackCompletedPaymentTransactionModel transactionModel);

    ThreedsInitialize initializeThreedSecure(CreatePaymentTransactionModel transactionModel);

    ThreedsPayment completeThreedSecure(CompleteThreedSecureTransactionModel transactionModel);
}
