package com.padr.buynow.domain.usecase.product.producttypeattributegroup.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdProductTypeAttributeGroup implements BaseUseCase<ProductTypeAttributeGroup, Long> {
    
    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    @Override
    public ProductTypeAttributeGroup perform(Long id) {
        return productTypeAttributeGroupService.findById(id);
    }
}
