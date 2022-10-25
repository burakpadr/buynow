package com.padr.buynow.outbound.persistence.attribute.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.product.entity.AttributeValue;

public interface AttributeValuePersistencePort {
    
    Optional<AttributeValue> findById(Long id);

    List<AttributeValue> findByAttributeIdAndIsActive(Long attributeId, Boolean isActive);
    
    AttributeValue save(AttributeValue attributeValue);

    List<AttributeValue> saveAll(List<AttributeValue> attributeValues);
}
