package com.padr.buynow.domain.usecase.product.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.UpdateProductTypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductType implements BaseUseCase<ProductType, UpdateProductTypeModel> {
    
    private final ProductTypeService productTypeService;
    
    @Override
    public ProductType perform(UpdateProductTypeModel model) {
        return productTypeService.updateProductType(model.getId(), model.to());
    }

}
