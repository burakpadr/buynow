package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface ProductTypeAttributePersistencePort extends BasePersistencePort<ProductTypeAttribute> {

    public Optional<ProductTypeAttribute> findByName(String name);

    List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);
}
