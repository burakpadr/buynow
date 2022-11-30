package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

public interface ProductTypeAttributeGroupPersistencePort {
    
    Optional<ProductTypeAttributeGroup> findById(Long id);

    Optional<ProductTypeAttributeGroup> findByName(String name);

    List<ProductTypeAttributeGroup> findByProductType(Long productTypeId);

    ProductTypeAttributeGroup save(ProductTypeAttributeGroup productTypeAttributeGroup);
}
