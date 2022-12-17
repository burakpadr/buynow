package com.padr.buynow.domain.usecase.product.producttypeattribute.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.CreateProductTypeAttributeValueUseCaseModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeAttributeUseCaseModel {

    private String label;
    private Long inputFieldTypeId;
    private Long productTypeAttributeGroupId;
    private List<CreateProductTypeAttributeValueUseCaseModel> valueModels;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .label(label)
                .build();
    }
}
