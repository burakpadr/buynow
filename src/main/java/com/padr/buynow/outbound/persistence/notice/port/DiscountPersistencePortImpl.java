package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.Discount;
import com.padr.buynow.outbound.persistence.notice.repository.DiscountRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DiscountPersistencePortImpl implements DiscountPersistencePort {
    
    private final DiscountRepository discountRepository;

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }
}
