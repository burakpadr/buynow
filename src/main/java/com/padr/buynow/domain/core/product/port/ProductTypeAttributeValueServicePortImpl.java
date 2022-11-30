package com.padr.buynow.domain.core.product.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributeValueServicePortImpl implements ProductTypeAttributeValueServicePort {
    
    private final ProductTypeAttributeValueService attributeValueService;

    @Override
    public List<ProductTypeAttributeValue> create(List<ProductTypeAttributeValue> attributeValues) {
        return attributeValueService.create(attributeValues);
    }

    @Override
    public ProductTypeAttributeValue findById(Long id) {
        return attributeValueService.findById(id);
    }

    @Override
    public List<ProductTypeAttributeValue> findByAttributeId(Long attributeId) {
        return attributeValueService.findByAttributeId(attributeId);
    }

    @Override
    public ProductTypeAttributeValue update(Long id, ProductTypeAttributeValue updateAttributeValue) {
        return attributeValueService.update(id, updateAttributeValue);
    }

    @Override
    public void deleteById(Long id) {
        attributeValueService.deleteById(id);
    }
}
