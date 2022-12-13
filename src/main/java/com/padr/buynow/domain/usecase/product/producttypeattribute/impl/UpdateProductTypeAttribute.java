package com.padr.buynow.domain.usecase.product.producttypeattribute.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattribute.model.UpdateProductTypeAttributeUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttribute
        implements BaseUseCase<ProductTypeAttribute, UpdateProductTypeAttributeUseCaseModel> {

    private final ProductTypeAttributeService productTypeAttributeService;

    @Override
    public ProductTypeAttribute perform(UpdateProductTypeAttributeUseCaseModel model) {
        return productTypeAttributeService.update(model.getId(), model.to());
    }
}
