package com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.UpdateProductTypeAttributeValueUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttributeValue
        implements BaseUseCase<List<ProductTypeAttributeValue>, List<UpdateProductTypeAttributeValueUseCaseModel>> {

    private final ProductTypeAttributeValueService productTypeAttributeValueService;

    @Override
    public List<ProductTypeAttributeValue> perform(
            List<UpdateProductTypeAttributeValueUseCaseModel> models) {
        return models.parallelStream().map(model -> {
            return productTypeAttributeValueService.update(model.getId(), model.to());
        }).collect(Collectors.toList());
    }
}
