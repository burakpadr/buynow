package com.padr.buynow.domain.usecase.product.producttype.model;

import com.padr.buynow.domain.core.product.entity.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeUseCaseModel {
    
    private String label;
    private Long parentProductTypeId;

    public ProductType to() {
        return ProductType.builder()
                .label(label)
                .build();
    }
}
