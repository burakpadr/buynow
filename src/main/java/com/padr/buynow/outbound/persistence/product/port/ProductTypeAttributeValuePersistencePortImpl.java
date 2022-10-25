package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.outbound.persistence.product.repository.ProductTypeAttributeValueRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributeValuePersistencePortImpl implements ProductTypeAttributeValuePersistencePort {
    
    private final ProductTypeAttributeValueRepository attributeValueRepository;

    @Override
    public Optional<ProductTypeAttributeValue> findById(Long id) {
        return attributeValueRepository.findById(id);
    }

    @Override
    public List<ProductTypeAttributeValue> findByProductTypeAttributeIdAndIsActive(Long attributeId, Boolean isActive) {
        return attributeValueRepository.findByProductTypeAttributeIdAndIsActive(attributeId, isActive);
    }

    @Override
    public ProductTypeAttributeValue save(ProductTypeAttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public List<ProductTypeAttributeValue> saveAll(List<ProductTypeAttributeValue> attributeValues) {
        return attributeValueRepository.saveAll(attributeValues);
    }
}
