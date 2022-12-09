package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import com.padr.buynow.domain.core.notice.entity.Discount;

public interface DiscountPersistencePort {
    
    Optional<Discount> findById(Long id);

    Discount save(Discount discount);
}
