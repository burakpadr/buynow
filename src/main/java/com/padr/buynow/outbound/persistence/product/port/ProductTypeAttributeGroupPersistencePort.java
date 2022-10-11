package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

public interface ProductTypeAttributeGroupPersistencePort {
    
    Optional<ProductTypeAttributeGroup> findById(Long id);

    Optional<ProductTypeAttributeGroup> findByName(String name);

    ProductTypeAttributeGroup save(ProductTypeAttributeGroup productTypeAttributeGroup);
}
