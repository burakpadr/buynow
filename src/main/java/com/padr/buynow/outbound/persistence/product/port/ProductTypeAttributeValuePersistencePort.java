package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface ProductTypeAttributeValuePersistencePort
        extends BasePersistencePort<ProductTypeAttributeValue> {

    List<ProductTypeAttributeValue> findByProductTypeAttributeIdAndIsActive(Long attributeId, Boolean isActive);

    List<ProductTypeAttributeValue> saveAll(List<ProductTypeAttributeValue> attributeValues);
}
