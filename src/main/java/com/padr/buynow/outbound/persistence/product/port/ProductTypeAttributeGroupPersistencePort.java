package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface ProductTypeAttributeGroupPersistencePort
        extends BasePersistencePort<ProductTypeAttributeGroup> {

    Optional<ProductTypeAttributeGroup> findByName(String name);

    List<ProductTypeAttributeGroup> findByProductType(Long productTypeId);
}
