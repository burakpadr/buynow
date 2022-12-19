package com.padr.buynow.domain.usecase.product.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeAttributeModel {

    private String label;
    private Long inputFieldTypeId;
    private Long productTypeAttributeGroupId;
    private List<CreateProductTypeAttributeValueModel> valueModels;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .label(label)
                .build();
    }
}
