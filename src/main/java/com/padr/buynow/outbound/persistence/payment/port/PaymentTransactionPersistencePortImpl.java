package com.padr.buynow.outbound.persistence.payment.port;

import com.padr.buynow.domain.core.payment.entity.PaymentTransaction;
import com.padr.buynow.outbound.persistence.payment.repository.PaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentTransactionPersistencePortImpl implements PaymentTransactionPersistencePort {

    private final PaymentTransactionRepository paymentTransactionRepository;

    @Override
    public Optional<PaymentTransaction> findById(Long id) {
        return paymentTransactionRepository.findById(id);
    }

    @Override
    public PaymentTransaction save(PaymentTransaction paymentTransaction) {
        return paymentTransactionRepository.save(paymentTransaction);
    }
}
