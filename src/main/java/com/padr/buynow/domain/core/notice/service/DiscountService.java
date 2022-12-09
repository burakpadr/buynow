package com.padr.buynow.domain.core.notice.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.entity.Discount;
import com.padr.buynow.domain.core.notice.exception.DiscountNotFoundException;
import com.padr.buynow.outbound.persistence.notice.port.DiscountPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscountService {
    
    private final DiscountPersistencePort discountPersistencePort;

    public Discount create(Discount discount) {
        discount.setIsActive(true);

        return discountPersistencePort.save(discount);
    }

    public Discount findById(Long id) {
        return discountPersistencePort.findById(id).orElseThrow(DiscountNotFoundException::new);
    }

    public Discount update(Long id, Discount updateDiscount) {
        Discount discount = findById(id);

        discount.setPercent(updateDiscount.getPercent());

        return discountPersistencePort.save(discount);
    }

    public void delete(Long id) {
        Discount discount = findById(id);

        discount.setIsActive(false);

        discountPersistencePort.save(discount);
    }
}
