package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.CreateProductTypeAttributeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductTypeAttribute
        implements BaseUseCase<ProductTypeAttribute, CreateProductTypeAttributeModel> {

    private final ProductTypeAttributeService productTypeAttributeService;
    private final InputFieldTypeService inputFieldTypeService;
    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    private final CreateProductTypeAttributeValue createProductTypeAttributeValue;

    @Override
    public ProductTypeAttribute perform(CreateProductTypeAttributeModel model) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(model.getInputFieldTypeId());

        ProductTypeAttributeGroup productTypeAttributeGroup = productTypeAttributeGroupService
                .findById(model.getProductTypeAttributeGroupId());

        ProductTypeAttribute productTypeAttribute = model.to();
        productTypeAttribute.setInputFieldType(inputFieldType);
        productTypeAttribute.setProductTypeAttributeGroup(productTypeAttributeGroup);

        ProductTypeAttribute savedProductTypeAttribute = productTypeAttributeService.create(productTypeAttribute);

        model.getValueModels().parallelStream().forEach(v -> {
            v.setProductTypeAttributeId(savedProductTypeAttribute.getId());
        });

        savedProductTypeAttribute
                .setProductTypeAttributeValues(createProductTypeAttributeValue.perform(model.getValueModels()));

        return savedProductTypeAttribute;
    }

}
