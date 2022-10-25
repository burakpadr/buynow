package com.padr.buynow.domain.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeAlreadyExistWithNameException;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeService {

    private final ProductTypeAttributePersistencePort attributePersistencePort;

    public ProductTypeAttribute create(ProductTypeAttribute attribute) {
        attributePersistencePort.findByName(attribute.getName())
                .orElseThrow(ProductTypeAttributeAlreadyExistWithNameException::new);

        attribute.setIsActive(true);

        return attributePersistencePort.save(attribute);
    }

    public ProductTypeAttribute findById(Long id) {
        return attributePersistencePort.findById(id).orElseThrow(ProductTypeAttributeNotFoundException::new);
    }

    public ProductTypeAttribute findByName(String name) {
        return attributePersistencePort.findByName(name).orElseThrow(ProductTypeAttributeNotFoundException::new);
    }

    public List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId) {
        return attributePersistencePort.findByProductTypeAttributeGroupId(productTypeAttributeGroupId);
    }

    public ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute) {
        ProductTypeAttribute attribute = findById(id);

        attributePersistencePort.findByName(updateAttribute.getName()).ifPresent(a -> {
            if (a.getId() != attribute.getId())
                throw new ProductTypeAttributeAlreadyExistWithNameException();
        });

        attribute.setName(updateAttribute.getName());
        attribute.setLabel(updateAttribute.getLabel());
        attribute.setInputFieldType(updateAttribute.getInputFieldType());

        return attributePersistencePort.save(attribute);
    }

    public void deleteById(Long id) {
        ProductTypeAttribute attribute = findById(id);

        attribute.setIsActive(false);

        attributePersistencePort.save(attribute);
    }
}
