package com.padr.buynow.domain.usecase.product.model;

import com.padr.buynow.domain.core.product.entity.ProductAttribute;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductAttributeModel {

    private Long id;
    private String value;
    private Long productTypeAttributeValueId;

    public ProductAttribute to() {
        return ProductAttribute.builder()
                .id(id)
                .value(value)
                .build();
    }
}
