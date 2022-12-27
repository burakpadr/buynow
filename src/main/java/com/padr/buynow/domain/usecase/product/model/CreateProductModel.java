package com.padr.buynow.domain.usecase.product.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductModel {
    
    private String header;
    private String description;
    private Long productTypeId;
    private Long ownerUserId;
    private List<CreateProductAttributeModel> attributeModels;

    public Product to() {
        return Product.builder()
                .header(header)
                .description(description)
                .build();
    }
}
