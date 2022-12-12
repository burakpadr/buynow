package com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.UpdateProductTypeAttributeValueUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttributeValueUseCase
        implements BaseUseCase<ProductTypeAttributeValue, UpdateProductTypeAttributeValueUseCaseModel> {

    private final ProductTypeAttributeValueService productTypeAttributeValueService;

    @Override
    public ProductTypeAttributeValue perform(
            UpdateProductTypeAttributeValueUseCaseModel updateProductTypeAttributeValueUseCaseModel) {
        return productTypeAttributeValueService.update(updateProductTypeAttributeValueUseCaseModel.getId(),
                updateProductTypeAttributeValueUseCaseModel.getUpdateProductTypeAttributeValueModel().to());
    }
}
