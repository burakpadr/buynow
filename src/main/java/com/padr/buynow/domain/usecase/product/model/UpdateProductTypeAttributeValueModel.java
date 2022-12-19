package com.padr.buynow.domain.usecase.product.model;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeValueModel {

    private Long id;
    private String value;

    public ProductTypeAttributeValue to() {
        return ProductTypeAttributeValue.builder()
                .value(value)
                .build();
    }
}
