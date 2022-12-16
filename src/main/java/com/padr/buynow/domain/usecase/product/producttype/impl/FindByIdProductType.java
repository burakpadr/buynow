package com.padr.buynow.domain.usecase.product.producttype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdProductType implements BaseUseCase<ProductType, Long> {
    
    private final ProductTypeService productTypeService;

    @Override
    public ProductType perform(Long id) {
        return productTypeService.findById(id);
    } 
}

