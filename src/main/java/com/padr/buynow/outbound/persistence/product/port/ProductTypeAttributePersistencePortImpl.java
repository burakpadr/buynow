package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.outbound.persistence.product.repository.ProductTypeAttributeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributePersistencePortImpl implements ProductTypeAttributePersistencePort {
    
    private final ProductTypeAttributeRepository attributeRepository;

    @Override
    public Optional<ProductTypeAttribute> findById(Long id) {
        return attributeRepository.findById(id);
    }

    @Override
    public ProductTypeAttribute save(ProductTypeAttribute attribute) {
        return attributeRepository.save(attribute);
    }

    
}
