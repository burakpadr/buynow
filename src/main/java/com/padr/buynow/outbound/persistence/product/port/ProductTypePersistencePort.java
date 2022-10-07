package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import com.padr.buynow.domain.product.entity.ProductType;

public interface ProductTypePersistencePort {
    
    Optional<ProductType> findById(Long id);

    Optional<ProductType> findByName(String name);

    ProductType save(ProductType productType);
}
