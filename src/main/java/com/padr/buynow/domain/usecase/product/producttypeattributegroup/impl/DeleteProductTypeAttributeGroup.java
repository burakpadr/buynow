package com.padr.buynow.domain.usecase.product.producttypeattributegroup.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProductTypeAttributeGroup implements BaseUseCase<Void, Long> {

    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    @Override
    public Void perform(Long k) {
        productTypeAttributeGroupService.deleteById(k);

        return null;
    }
}
