package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductAttribute;

public interface ProductAttributePersistencePort {

    Optional<ProductAttribute> findById(Long id);
    
    List<ProductAttribute> findByProductId(Long productId);

    ProductAttribute save(ProductAttribute productAttribute);

    List<ProductAttribute> saveAll(List<ProductAttribute> productAttributes);
}
