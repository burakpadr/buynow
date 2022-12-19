package com.padr.buynow.domain.usecase.product.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.CreateProductTypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductType implements BaseUseCase<ProductType, CreateProductTypeModel> {

    private final ProductTypeService productTypeService;

    @Override
    public ProductType perform(CreateProductTypeModel model) {
        ProductType productType = model.to();

        if (Objects.nonNull(model.getParentProductTypeId())) {
            ProductType parentProductType = productTypeService.findById(model.getParentProductTypeId());

            productType.setParentProductType(parentProductType);
        }

        return productTypeService.createProductType(productType);
    }

}
