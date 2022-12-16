package com.padr.buynow.domain.usecase.product.producttype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttype.model.UpdateProductTypeUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductType implements BaseUseCase<ProductType, UpdateProductTypeUseCaseModel> {
    
    private final ProductTypeService productTypeService;
    
    @Override
    public ProductType perform(UpdateProductTypeUseCaseModel model) {
        return productTypeService.updateProductType(model.getId(), model.to());
    }

}
