package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface ProductTypeAttributeValuePersistencePort
        extends BaseCacheAndPersistencePort<ProductTypeAttributeValue> {

    List<ProductTypeAttributeValue> findByProductTypeAttributeIdAndIsActive(Long attributeId, Boolean isActive);

    List<ProductTypeAttributeValue> saveAll(List<ProductTypeAttributeValue> attributeValues);
}
