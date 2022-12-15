package com.padr.buynow.domain.usecase.product.producttypeattributegroup.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributegroup.model.CreateProductTypeAttributeGroupUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductTypeAttributeGroup
        implements BaseUseCase<ProductTypeAttributeGroup, CreateProductTypeAttributeGroupUseCaseModel> {

    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;
    private final ProductTypeService productTypeService;

    @Override
    public ProductTypeAttributeGroup perform(CreateProductTypeAttributeGroupUseCaseModel model) {
        ProductType productType = productTypeService.findById(model.getProductTypeId());

        ProductTypeAttributeGroup productTypeAttributeGroup = model.to();
        productTypeAttributeGroup.setProductType(productType);

        return productTypeAttributeGroupService.create(productTypeAttributeGroup);
    }
}
