package com.padr.buynow.outbound.persistence.attribute.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.attribute.entity.AttributeValue;
import com.padr.buynow.outbound.persistence.attribute.repository.AttributeValueRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributeValuePersistencePortImpl implements AttributeValuePersistencePort {
    
    private final AttributeValueRepository attributeValueRepository;

    @Override
    public Optional<AttributeValue> findById(Long id) {
        return attributeValueRepository.findById(id);
    }

    @Override
    public List<AttributeValue> findByAttributeIdAndIsActive(Long attributeId, Boolean isActive) {
        return attributeValueRepository.findByAttributeIdAndIsActive(attributeId, isActive);
    }

    @Override
    public AttributeValue save(AttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }
}
