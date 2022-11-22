package com.padr.buynow.outbound.persistence.product.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.Product;
import com.padr.buynow.outbound.persistence.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductPersistencePortImpl implements ProductPersistencePort {
    
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
