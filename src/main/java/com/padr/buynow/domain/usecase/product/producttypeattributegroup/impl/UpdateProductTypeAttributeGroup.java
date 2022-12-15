package com.padr.buynow.domain.usecase.product.producttypeattributegroup.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributegroup.model.UpdateProductTypeAttributeGroupUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttributeGroup
        implements BaseUseCase<ProductTypeAttributeGroup, UpdateProductTypeAttributeGroupUseCaseModel> {

    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    @Override
    public ProductTypeAttributeGroup perform(UpdateProductTypeAttributeGroupUseCaseModel model) {
        return productTypeAttributeGroupService.update(model.getId(), model.to());
    }
}
