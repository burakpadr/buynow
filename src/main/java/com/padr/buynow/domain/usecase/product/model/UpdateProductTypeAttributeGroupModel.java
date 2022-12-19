package com.padr.buynow.domain.usecase.product.model;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeGroupModel {
    
    private Long id;
    private String label;

    public ProductTypeAttributeGroup to() {
        return ProductTypeAttributeGroup.builder()
                .label(label)
                .build();
    }
}
