package com.padr.buynow.domain.attribute.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.attribute.entity.Attribute;
import com.padr.buynow.domain.attribute.exception.AttributeAlreadyExistWithNameException;
import com.padr.buynow.domain.attribute.exception.AttributeNotFoundException;
import com.padr.buynow.outbound.persistence.attribute.port.AttributePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttributeService {

    private final AttributePersistencePort attributePersistencePort;

    public Attribute create(Attribute attribute) {
        attributePersistencePort.findByName(attribute.getName())
                .orElseThrow(AttributeAlreadyExistWithNameException::new);

        attribute.setIsActive(true);

        return attributePersistencePort.save(attribute);
    }

    public Attribute findById(Long id) {
        return attributePersistencePort.findById(id).orElseThrow(AttributeNotFoundException::new);
    }

    public Attribute findByName(String name) {
        return attributePersistencePort.findByName(name).orElseThrow(AttributeNotFoundException::new);
    }

    public List<Attribute> findByProductTypeAttrinuteGroupId(Long productTypeAttributeGroupId) {
        return attributePersistencePort.findByProductTypeAttributeGroupId(productTypeAttributeGroupId);
    }

    public Attribute update(Long id, Attribute updateAttribute) {
        Attribute attribute = findById(id);

        attributePersistencePort.findByName(updateAttribute.getName()).ifPresent(a -> {
            if (a.getId() != attribute.getId())
                throw new AttributeAlreadyExistWithNameException();
        });

        attribute.setName(updateAttribute.getName());
        attribute.setLabel(updateAttribute.getLabel());
        attribute.setInputFieldType(updateAttribute.getInputFieldType());

        return attributePersistencePort.save(attribute);
    }

    public void deleteById(Long id) {
        Attribute attribute = findById(id);

        attribute.setIsActive(false);

        attributePersistencePort.save(attribute);
    }
}
