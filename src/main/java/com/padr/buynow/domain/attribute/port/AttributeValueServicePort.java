package com.padr.buynow.domain.attribute.port;

import java.util.List;

import com.padr.buynow.domain.attribute.entity.AttributeValue;

public interface AttributeValueServicePort {
    
    List<AttributeValue> create(List<AttributeValue> attributeValues);

    AttributeValue findById(Long id);

    List<AttributeValue> findByAttributeId(Long attributeId);

    AttributeValue update(Long id, AttributeValue updateAttributeValue);

    void deleteById(Long id);
}
