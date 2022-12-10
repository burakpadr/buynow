package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface ProductTypePersistencePort extends BaseCacheAndPersistencePort<ProductType> {

    Optional<ProductType> findByName(String name);

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);
}
