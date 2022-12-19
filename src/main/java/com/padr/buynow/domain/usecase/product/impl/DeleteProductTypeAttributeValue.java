package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProductTypeAttributeValue implements BaseUseCase<Void, Long> {
    
    private final ProductTypeAttributeValueService productTypeAttributeValueService;

    @Override
    public Void perform(Long id) {
        productTypeAttributeValueService.deleteById(id);

        return null;
    }
}
