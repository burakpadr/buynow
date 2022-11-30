package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductAttribute;
import com.padr.buynow.outbound.persistence.product.repository.ProductAttributeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductAttributePersistencePortImpl implements ProductAttributePersistencePort {

    private final ProductAttributeRepository productAttributeRepository;

    @Override
    public Optional<ProductAttribute> findById(Long id) {
        return productAttributeRepository.findById(id);
    }

    @Override
    public List<ProductAttribute> findByProductId(Long productId) {
        return productAttributeRepository.findByProductId(productId);
    }

    @Override
    public List<ProductAttribute> saveAll(List<ProductAttribute> productAttributes) {
        return productAttributeRepository.saveAll(productAttributes);
    }

    @Override
    public ProductAttribute save(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }
}
