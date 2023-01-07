package com.padr.buynow.domain.core.payment.service;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.*;
import com.padr.buynow.domain.core.payment.entity.PaymentTransaction;
import com.padr.buynow.domain.core.payment.exception.PaymentException;
import com.padr.buynow.outbound.iyzipay.model.transaction.*;
import com.padr.buynow.outbound.iyzipay.port.IyzipayClientPort;
import com.padr.buynow.outbound.persistence.payment.port.PaymentTransactionPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final IyzipayClientPort iyzipayClientPort;

    private final PaymentTransactionPersistencePort paymentTransactionPersistencePort;

    private final Environment environment;

    public Payment pay(CreatePaymentTransactionModel transactionModel) {
        Payment payment = iyzipayClientPort.pay(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(payment);

        Optional<PaymentItem> paymentItemOptional = payment.getPaymentItems().stream().findAny();

        if (!paymentItemOptional.isPresent()) {
            cancelPayment(CancelCompletedPaymentTransactionModel.builder()
                    .locale(Locale.EN.getValue())
                    .conversationId(null)
                    .paymentId(payment.getPaymentId())
                    .ip(environment.getProperty("server.address"))
                    .build());

            throw new PaymentException();
        }

        PaymentTransaction paymentTransaction = PaymentTransaction.builder()
                .paymentId(payment.getPaymentId())
                .paymentTransactionId(payment.getPaymentItems().get(0).getPaymentTransactionId())
                .ipAddress(environment.getProperty("server.address"))
                .build();

        paymentTransactionPersistencePort.save(paymentTransaction);

        return payment;
    }

    public Cancel cancelPayment(CancelCompletedPaymentTransactionModel transactionModel) {
        Cancel cancel = iyzipayClientPort.cancelPayment(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(cancel);

        return cancel;
    }

    public Refund payback(PayBackCompletedPaymentTransactionModel transactionModel) {
        Refund refund = iyzipayClientPort.payBack(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(refund);

        return refund;
    }

    public InstallmentInfo findInstallment(FindInstallmentTransactionModel transactionModel) {
        InstallmentInfo installmentInfo = iyzipayClientPort.findInstallment(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(installmentInfo);

        return installmentInfo;
    }

    public Payment findPayment(FindCompletedPaymentTransactionModel transactionModel) {
        Payment payment = iyzipayClientPort.findPayment(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(payment);

        return payment;
    }

    public ThreedsInitialize initializeThreedSecurePayment(CreatePaymentTransactionModel transactionModel) {
        ThreedsInitialize threedsInitialize = iyzipayClientPort.initializeThreedSecure(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(threedsInitialize);

        return threedsInitialize;
    }

    public ThreedsPayment completeThreedSecurePayment(CompleteThreedSecureTransactionModel transactionModel) {
        ThreedsPayment threedsPayment = iyzipayClientPort.completeThreedSecure(transactionModel);

        throwPaymentExceptionIfStatusIsFailure(threedsPayment);

        Optional<PaymentItem> paymentItemOptional = threedsPayment.getPaymentItems().stream().findAny();

        if (!paymentItemOptional.isPresent()) {
            cancelPayment(CancelCompletedPaymentTransactionModel.builder()
                    .locale(Locale.EN.getValue())
                    .conversationId(null)
                    .paymentId(threedsPayment.getPaymentId())
                    .ip(environment.getProperty("server.address"))
                    .build());

            throw new PaymentException();
        }

        PaymentTransaction paymentTransaction = PaymentTransaction.builder()
                .paymentId(threedsPayment.getPaymentId())
                .paymentTransactionId(threedsPayment.getPaymentItems().get(0).getPaymentTransactionId())
                .ipAddress(environment.getProperty("server.address"))
                .build();

        paymentTransactionPersistencePort.save(paymentTransaction);

        return threedsPayment;
    }

    public static <T extends IyzipayResource> void throwPaymentExceptionIfStatusIsFailure(T t) {
        if (t.getStatus().equals(Status.FAILURE.getValue()))
            throw new PaymentException(t.getErrorMessage());
    }
}
