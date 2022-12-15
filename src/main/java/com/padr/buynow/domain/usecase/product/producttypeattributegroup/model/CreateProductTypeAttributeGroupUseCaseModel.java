package com.padr.buynow.domain.usecase.product.producttypeattributegroup.model;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeAttributeGroupUseCaseModel {
    
    private String label;
    private Long productTypeId;

    public ProductTypeAttributeGroup to() {
        return ProductTypeAttributeGroup.builder()
                .label(label)
                .build();
    }
}
