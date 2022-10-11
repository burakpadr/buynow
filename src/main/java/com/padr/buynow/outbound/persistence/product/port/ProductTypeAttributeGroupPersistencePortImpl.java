package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.outbound.persistence.product.repository.ProductTypeAttributeGroupRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributeGroupPersistencePortImpl implements ProductTypeAttributeGroupPersistencePort {
    
    private final ProductTypeAttributeGroupRepository productTypeAttributeGroupRepository;

    @Override
    public Optional<ProductTypeAttributeGroup> findById(Long id) {
        return productTypeAttributeGroupRepository.findById(id);
    }

    @Override
    public Optional<ProductTypeAttributeGroup> findByName(String name) {
        return productTypeAttributeGroupRepository.findByName(name);
    }

    @Override
    public ProductTypeAttributeGroup save(ProductTypeAttributeGroup productTypeAttributeGroup) {
        return productTypeAttributeGroupRepository.save(productTypeAttributeGroup);
    }
}
