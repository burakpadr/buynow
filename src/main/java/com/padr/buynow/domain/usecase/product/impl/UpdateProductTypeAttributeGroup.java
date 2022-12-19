package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.UpdateProductTypeAttributeGroupModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttributeGroup
        implements BaseUseCase<ProductTypeAttributeGroup, UpdateProductTypeAttributeGroupModel> {

    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    @Override
    public ProductTypeAttributeGroup perform(UpdateProductTypeAttributeGroupModel model) {
        return productTypeAttributeGroupService.update(model.getId(), model.to());
    }
}
