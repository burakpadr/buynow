package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProduct implements BaseUseCase<Void, Long> {
    
    private final ProductService productService;

    @Override
    public Void perform(Long id) {
        productService.delete(id);

        return null;
    }
}
