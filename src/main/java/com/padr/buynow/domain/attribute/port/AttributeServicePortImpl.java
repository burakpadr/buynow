package com.padr.buynow.domain.attribute.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.attribute.entity.Attribute;
import com.padr.buynow.domain.attribute.service.AttributeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributeServicePortImpl implements AttributeServicePort {

    private final AttributeService attributeService;

    @Override
    public Attribute create(Attribute attribute) {
        return attributeService.create(attribute);
    }

    @Override
    public Attribute findById(Long id) {
        return attributeService.findById(id);
    }

    @Override
    public Attribute findByName(String name) {
        return attributeService.findByName(name);
    }

    @Override
    public List<Attribute> findByProductTypeAttrinuteGroupId(Long productTypeAttributeGroupId) {
        return attributeService.findByProductTypeAttrinuteGroupId(productTypeAttributeGroupId);
    }

    @Override
    public Attribute update(Long id, Attribute updateAttribute) {
        return attributeService.update(id, updateAttribute);
    }

    @Override
    public void deleteById(Long id) {
        attributeService.deleteById(id);
    }
}
