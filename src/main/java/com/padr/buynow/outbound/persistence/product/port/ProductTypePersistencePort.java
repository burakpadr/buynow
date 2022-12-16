package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface ProductTypePersistencePort extends BasePersistencePort<ProductType> {

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);
}
