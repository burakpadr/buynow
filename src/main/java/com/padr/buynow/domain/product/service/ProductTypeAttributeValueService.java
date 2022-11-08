package com.padr.buynow.domain.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeValueNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributeValuePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeValueService {

    private final ProductTypeAttributeValuePersistencePort productTypeAttributeValuePersistencePort;

    public List<ProductTypeAttributeValue> create(List<ProductTypeAttributeValue> attributeValues) {
        attributeValues.parallelStream().forEach(attributeValue -> {
            attributeValue.setIsActive(true);
        });

        return productTypeAttributeValuePersistencePort.saveAll(attributeValues);
    }

    public ProductTypeAttributeValue findById(Long id) {
        return productTypeAttributeValuePersistencePort.findById(id)
                .orElseThrow(ProductTypeAttributeValueNotFoundException::new);
    }

    public List<ProductTypeAttributeValue> findByAttributeId(Long attributeId) {
        return productTypeAttributeValuePersistencePort.findByProductTypeAttributeIdAndIsActive(attributeId, true);
    }

    public ProductTypeAttributeValue update(Long id, ProductTypeAttributeValue updateAttributeValue) {
        ProductTypeAttributeValue attributeValue = findById(id);

        attributeValue.setValue(updateAttributeValue.getValue());

        return productTypeAttributeValuePersistencePort.save(attributeValue);
    }

    public void deleteById(Long id) {
        ProductTypeAttributeValue attributeValue = findById(id);

        attributeValue.setIsActive(false);

        productTypeAttributeValuePersistencePort.save(attributeValue);
    }
}
