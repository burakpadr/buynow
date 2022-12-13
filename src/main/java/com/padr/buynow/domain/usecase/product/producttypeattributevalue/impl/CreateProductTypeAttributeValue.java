package com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.CreateProductTypeAttributeValueUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProductTypeAttributeValue
        implements BaseUseCase<List<ProductTypeAttributeValue>, List<CreateProductTypeAttributeValueUseCaseModel>> {

    private final ProductTypeAttributeValueService productTypeAttributeValueService;
    private final ProductTypeAttributeService productTypeAttributeService;

    @Override
    public List<ProductTypeAttributeValue> perform(List<CreateProductTypeAttributeValueUseCaseModel> requests) {
        List<ProductTypeAttributeValue> values = new ArrayList<>();

        requests.parallelStream().forEach(request -> {
            ProductTypeAttribute productTypeAttribute = productTypeAttributeService
                    .findById(request.getProductTypeAttributeId());

            ProductTypeAttributeValue productTypeAttributeValue = request.to();
            productTypeAttributeValue.setProductTypeAttribute(productTypeAttribute);

            values.add(productTypeAttributeValue);
        });

        return productTypeAttributeValueService.create(values);
    }
}
