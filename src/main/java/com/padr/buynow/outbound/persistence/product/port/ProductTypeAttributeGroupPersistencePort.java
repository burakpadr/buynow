package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface ProductTypeAttributeGroupPersistencePort
        extends BaseCacheAndPersistencePort<ProductTypeAttributeGroup> {

    Optional<ProductTypeAttributeGroup> findByName(String name);

    List<ProductTypeAttributeGroup> findByProductType(Long productTypeId);
}
