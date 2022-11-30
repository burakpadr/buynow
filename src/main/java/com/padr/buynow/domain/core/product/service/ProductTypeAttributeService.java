package com.padr.buynow.domain.core.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeAlreadyExistWithNameException;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeService {

    private final ProductTypeAttributePersistencePort productTypeAttributePersistencePort;

    public ProductTypeAttribute create(ProductTypeAttribute attribute) {
        productTypeAttributePersistencePort.findByName(attribute.getName()).ifPresent(p -> {
            throw new ProductTypeAttributeAlreadyExistWithNameException();
        });

        attribute.setIsActive(true);

        return productTypeAttributePersistencePort.save(attribute);
    }

    public ProductTypeAttribute findById(Long id) {
        return productTypeAttributePersistencePort.findById(id).orElseThrow(ProductTypeAttributeNotFoundException::new);
    }

    public ProductTypeAttribute findByName(String name) {
        return productTypeAttributePersistencePort.findByName(name)
                .orElseThrow(ProductTypeAttributeNotFoundException::new);
    }

    public List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId) {
        return productTypeAttributePersistencePort.findByProductTypeAttributeGroupId(productTypeAttributeGroupId);
    }

    public ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute) {
        ProductTypeAttribute attribute = findById(id);

        productTypeAttributePersistencePort.findByName(updateAttribute.getName()).ifPresent(a -> {
            if (a.getId() != attribute.getId())
                throw new ProductTypeAttributeAlreadyExistWithNameException();
        });

        attribute.setName(updateAttribute.getName());
        attribute.setLabel(updateAttribute.getLabel());
        attribute.setInputFieldType(updateAttribute.getInputFieldType());

        return productTypeAttributePersistencePort.save(attribute);
    }

    public void deleteById(Long id) {
        ProductTypeAttribute attribute = findById(id);

        attribute.setIsActive(false);

        productTypeAttributePersistencePort.save(attribute);
    }
}
