package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

public interface ProductTypeAttributePersistencePort {
    
    public Optional<ProductTypeAttribute> findById(Long id);

    public Optional<ProductTypeAttribute> findByName(String name);

    List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);

    public ProductTypeAttribute save(ProductTypeAttribute attribute);
}
