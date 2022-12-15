package com.padr.buynow.domain.usecase.product.producttypeattribute.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProductTypeAttribute implements BaseUseCase<Void, Long> {

    private final ProductTypeAttributeService productTypeAttributeService;

    @Override
    public Void perform(Long id) {
        productTypeAttributeService.deleteById(id);

        return null;
    }
}
