package com.padr.buynow.domain.usecase.product.producttypeattribute.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl.DeleteProductTypeAttributeValue;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteProductTypeAttribute implements BaseUseCase<Void, Long> {

    private final ProductTypeAttributeService productTypeAttributeService;

    private final DeleteProductTypeAttributeValue deleteProductTypeAttributeValue;

    @Override
    public Void perform(Long id) {
        ProductTypeAttribute productTypeAttribute = productTypeAttributeService.findById(id);

        productTypeAttribute.getProductTypeAttributeValues().parallelStream().forEach(value -> {
            deleteProductTypeAttributeValue.perform(value.getId());
        });

        productTypeAttributeService.deleteById(id);

        return null;
    }
}
