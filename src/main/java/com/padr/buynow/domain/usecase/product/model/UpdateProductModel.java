package com.padr.buynow.domain.usecase.product.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.Product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateProductModel {
    
    private Long id;
    private String header;
    private String description;
    private List<UpdateProductAttributeModel> attributeModels;

    public Product to() {
        return Product.builder()
                .header(header)
                .description(description)
                .build();
    }
}
