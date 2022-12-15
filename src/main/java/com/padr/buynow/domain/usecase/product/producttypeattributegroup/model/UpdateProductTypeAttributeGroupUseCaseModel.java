package com.padr.buynow.domain.usecase.product.producttypeattributegroup.model;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeGroupUseCaseModel {
    
    private Long id;
    private String label;

    public ProductTypeAttributeGroup to() {
        return ProductTypeAttributeGroup.builder()
                .label(label)
                .build();
    }
}
