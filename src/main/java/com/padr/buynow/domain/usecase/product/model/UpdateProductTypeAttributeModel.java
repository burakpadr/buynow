package com.padr.buynow.domain.usecase.product.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeModel {
    
    private Long id;
    private String label;
    private List<UpdateProductTypeAttributeValueModel> valueModels;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .label(label)
                .build();
    }
}
