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
    
    private final ProductTypeAttributeValuePersistencePort attributeValuePersistencePort;

    public List<ProductTypeAttributeValue> create(List<ProductTypeAttributeValue> attributeValues) {
        attributeValues.parallelStream().forEach(attributeValue -> {
            attributeValue.setIsActive(true);
        });

        return attributeValuePersistencePort.saveAll(attributeValues);
    }

    public ProductTypeAttributeValue findById(Long id) {
        return attributeValuePersistencePort.findById(id).orElseThrow(ProductTypeAttributeValueNotFoundException::new);
    }

    public List<ProductTypeAttributeValue> findByAttributeId(Long attributeId) {
        return attributeValuePersistencePort.findByProductTypeAttributeIdAndIsActive(attributeId, true);
    }

    public ProductTypeAttributeValue update(Long id, ProductTypeAttributeValue updateAttributeValue) {
        ProductTypeAttributeValue attributeValue = findById(id);

        attributeValue.setValue(updateAttributeValue.getValue());

        return attributeValuePersistencePort.save(attributeValue);
    }

    public void deleteById(Long id) {
        ProductTypeAttributeValue attributeValue = findById(id);

        attributeValue.setIsActive(false);

        attributeValuePersistencePort.save(attributeValue);
    }
}
