package com.padr.buynow.domain.usecase.product.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.UpdateProductTypeAttributeValueModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttributeValue
        implements BaseUseCase<List<ProductTypeAttributeValue>, List<UpdateProductTypeAttributeValueModel>> {

    private final ProductTypeAttributeValueService productTypeAttributeValueService;

    @Override
    public List<ProductTypeAttributeValue> perform(
            List<UpdateProductTypeAttributeValueModel> models) {
        return models.parallelStream().map(model -> {
            return productTypeAttributeValueService.update(model.getId(), model.to());
        }).collect(Collectors.toList());
    }
}
