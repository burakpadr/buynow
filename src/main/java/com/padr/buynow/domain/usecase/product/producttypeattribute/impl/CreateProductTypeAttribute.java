package com.padr.buynow.domain.usecase.product.producttypeattribute.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattribute.model.CreateProductTypeAttributeUseCaseModel;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl.CreateProductTypeAttributeValue;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductTypeAttribute implements BaseUseCase<ProductTypeAttribute, CreateProductTypeAttributeUseCaseModel> {

    private final ProductTypeAttributeService productTypeAttributeService;
    private final InputFieldTypeService inputFieldTypeService;
    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    private final CreateProductTypeAttributeValue createProductTypeAttributeValue;

    @Override
    public ProductTypeAttribute perform(CreateProductTypeAttributeUseCaseModel model) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(model.getInputFieldTypeId());

        ProductTypeAttributeGroup productTypeAttributeGroup = productTypeAttributeGroupService
                .findById(model.getProductTypeAttributeGroupId());

        ProductTypeAttribute productTypeAttribute = model.to();
        productTypeAttribute.setInputFieldType(inputFieldType);
        productTypeAttribute.setProductTypeAttributeGroup(productTypeAttributeGroup);

        productTypeAttribute = productTypeAttributeService.create(productTypeAttribute);
        productTypeAttribute.setProductTypeAttributeValues(createProductTypeAttributeValue.perform(model.getValues()));

        return productTypeAttribute;
    }

}
