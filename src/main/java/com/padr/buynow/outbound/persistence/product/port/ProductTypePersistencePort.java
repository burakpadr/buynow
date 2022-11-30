package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductType;

public interface ProductTypePersistencePort {
    
    Optional<ProductType> findById(Long id);

    Optional<ProductType> findByName(String name);

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);

    ProductType save(ProductType productType);
}
