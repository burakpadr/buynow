package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.Product;

public interface ProductPersistencePort {
    
    Optional<Product> findById(Long id);

    Product save(Product product);
}
