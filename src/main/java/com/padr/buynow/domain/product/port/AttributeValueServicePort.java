package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.AttributeValue;

public interface AttributeValueServicePort {
    
    List<AttributeValue> create(List<AttributeValue> attributeValues);

    AttributeValue findById(Long id);

    List<AttributeValue> findByAttributeId(Long attributeId);

    AttributeValue update(Long id, AttributeValue updateAttributeValue);

    void deleteById(Long id);
}
