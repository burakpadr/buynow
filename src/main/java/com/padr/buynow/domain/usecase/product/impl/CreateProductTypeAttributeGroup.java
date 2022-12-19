package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.CreateProductTypeAttributeGroupModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductTypeAttributeGroup
        implements BaseUseCase<ProductTypeAttributeGroup, CreateProductTypeAttributeGroupModel> {

    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;
    private final ProductTypeService productTypeService;

    @Override
    public ProductTypeAttributeGroup perform(CreateProductTypeAttributeGroupModel model) {
        ProductType productType = productTypeService.findById(model.getProductTypeId());

        ProductTypeAttributeGroup productTypeAttributeGroup = model.to();
        productTypeAttributeGroup.setProductType(productType);

        return productTypeAttributeGroupService.create(productTypeAttributeGroup);
    }
}
