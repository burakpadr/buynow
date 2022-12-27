package com.padr.buynow.domain.usecase.product.model;

import com.padr.buynow.domain.core.product.entity.ProductAttribute;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductAttributeModel {
    
    private String value;
    private Long productId;
    private Long productTypeAttributeId;
    private Long productTypeAttributeValueId;

    public ProductAttribute to() {
        return ProductAttribute.builder()
                .value(value)
                .build();
    }
}
