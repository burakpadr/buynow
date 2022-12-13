package com.padr.buynow.domain.core.product.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeService {

    private final ProductTypeAttributePersistencePort productTypeAttributePersistencePort;

    public ProductTypeAttribute create(ProductTypeAttribute attribute) {
        attribute.setIsActive(true);

        return productTypeAttributePersistencePort.save(attribute);
    }

    public ProductTypeAttribute findById(Long id) {
        return productTypeAttributePersistencePort.findById(id).orElseThrow(ProductTypeAttributeNotFoundException::new);
    }

    public ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute) {
        ProductTypeAttribute attribute = findById(id);

        attribute.setLabel(updateAttribute.getLabel());

        return productTypeAttributePersistencePort.save(attribute);
    }

    public void deleteById(Long id) {
        ProductTypeAttribute attribute = findById(id);

        attribute.setIsActive(false);

        productTypeAttributePersistencePort.save(attribute);
    }
}
