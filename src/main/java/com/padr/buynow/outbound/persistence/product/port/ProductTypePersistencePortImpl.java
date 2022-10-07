package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.ProductType;
import com.padr.buynow.outbound.persistence.product.repository.ProductTypeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypePersistencePortImpl implements ProductTypePersistencePort {
    
    private final ProductTypeRepository productTypeRepository;

    @Override
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public Optional<ProductType> findByName(String name) {
        return productTypeRepository.findByName(name);
    }

    @Override
    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }
}
