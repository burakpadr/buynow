package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindProductById implements BaseUseCase<Product, Long> {
    
    private final ProductService productService;

    @Override
    public Product perform(Long model) {
        return productService.findById(model);
    }
}
