package com.padr.buynow.outbound.persistence.attribute.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.Attribute;
import com.padr.buynow.outbound.persistence.attribute.repository.AttributeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributePersistencePortImpl implements AttributePersistencePort {
    
    private final AttributeRepository attributeRepository;

    @Override
    public Optional<Attribute> findById(Long id) {
        return attributeRepository.findById(id);
    }

    @Override
    public Optional<Attribute> findByName(String name) {
        return attributeRepository.findByName(name);
    }

    @Override
    public List<Attribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId) {
        return attributeRepository.findByProductTypeAttributeGroupId(productTypeAttributeGroupId);
    }

    @Override
    public Attribute save(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    
}
