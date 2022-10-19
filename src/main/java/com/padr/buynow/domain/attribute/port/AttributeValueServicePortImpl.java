package com.padr.buynow.domain.attribute.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.attribute.entity.AttributeValue;
import com.padr.buynow.domain.attribute.service.AttributeValueService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributeValueServicePortImpl implements AttributeValueServicePort {
    
    private final AttributeValueService attributeValueService;

    @Override
    public AttributeValue create(AttributeValue attributeValue) {
        return attributeValueService.create(attributeValue);
    }

    @Override
    public AttributeValue findById(Long id) {
        return attributeValueService.findById(id);
    }

    @Override
    public List<AttributeValue> findByAttributeId(Long attributeId) {
        return attributeValueService.findByAttributeId(attributeId);
    }

    @Override
    public AttributeValue update(Long id, AttributeValue updateAttributeValue) {
        return attributeValueService.update(id, updateAttributeValue);
    }

    @Override
    public void deleteById(Long id) {
        attributeValueService.deleteById(id);
    }
}
