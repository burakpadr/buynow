package com.padr.buynow.domain.attribute.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.attribute.entity.AttributeValue;
import com.padr.buynow.domain.attribute.exception.AttributeValueNotFoundException;
import com.padr.buynow.outbound.persistence.attribute.port.AttributeValuePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttributeValueService {
    
    private final AttributeValuePersistencePort attributeValuePersistencePort;

    public AttributeValue create(AttributeValue attributeValue) {
        attributeValue.setIsActive(true);

        return attributeValuePersistencePort.save(attributeValue);
    }

    public AttributeValue findById(Long id) {
        return attributeValuePersistencePort.findById(id).orElseThrow(AttributeValueNotFoundException::new);
    }

    public List<AttributeValue> findByAttributeId(Long attributeId) {
        return attributeValuePersistencePort.findByAttributeIdAndIsActive(attributeId, true);
    }

    public AttributeValue update(Long id, AttributeValue updateAttributeValue) {
        AttributeValue attributeValue = findById(id);

        attributeValue.setValue(updateAttributeValue.getValue());

        return attributeValuePersistencePort.save(attributeValue);
    }

    public void deleteById(Long id) {
        AttributeValue attributeValue = findById(id);

        attributeValue.setIsActive(false);

        attributeValuePersistencePort.save(attributeValue);
    }
}
