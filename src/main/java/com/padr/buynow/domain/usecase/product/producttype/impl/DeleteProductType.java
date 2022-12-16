package com.padr.buynow.domain.usecase.product.producttype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProductType implements BaseUseCase<Void, Long> {

    private final ProductTypeService productTypeService;

    @Override
    public Void perform(Long id) {
        productTypeService.deleteById(id);

        return null;
    }
}
