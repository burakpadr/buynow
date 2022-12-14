package com.padr.buynow.domain.usecase.product.producttypeattribute.model;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeAttributeUseCaseModel {

    private String label;
    private Long inputFieldTypeId;
    private Long productTypeAttributeGroupId;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .label(label)
                .build();
    }
}
