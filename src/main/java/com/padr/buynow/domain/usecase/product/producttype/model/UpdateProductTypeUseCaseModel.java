package com.padr.buynow.domain.usecase.product.producttype.model;

import com.padr.buynow.domain.core.product.entity.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeUseCaseModel {

    private Long id;
    private String label;

    public ProductType to() {
        return ProductType.builder()
                .label(label)
                .build();
    }
}
