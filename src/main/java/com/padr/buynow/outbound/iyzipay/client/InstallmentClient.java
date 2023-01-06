package com.padr.buynow.outbound.iyzipay.client;

import com.iyzipay.Options;
import com.iyzipay.model.InstallmentInfo;
import com.padr.buynow.outbound.iyzipay.model.transaction.FindInstallmentTransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InstallmentClient {

    private final Options options;

    public InstallmentInfo findInstallment(FindInstallmentTransactionModel transactionModel) {
        return InstallmentInfo.retrieve(transactionModel.to(), options);
    }
}
