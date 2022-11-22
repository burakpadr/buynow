package com.padr.buynow.domain.product.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.Product;
import com.padr.buynow.domain.product.exception.ProductNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductPersistencePort productPersistencePort;

    public Product create(Product product) {
        product.setIsActive(true);

        return productPersistencePort.save(product);
    }

    public Product findById(Long id) {
        return productPersistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product update(Long id, Product updateProduct) {
        Product product = findById(id);

        product.setHeader(updateProduct.getHeader());
        product.setDescription(updateProduct.getDescription());
        product.setAddress(updateProduct.getAddress());

        return productPersistencePort.save(product);
    }

    public void delete(Long id) {
        Product product = findById(id);

        product.setIsActive(false);

        productPersistencePort.save(product);
    }
}
