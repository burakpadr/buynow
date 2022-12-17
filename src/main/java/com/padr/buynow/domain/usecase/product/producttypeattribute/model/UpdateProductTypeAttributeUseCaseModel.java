package com.padr.buynow.domain.usecase.product.producttypeattribute.model;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.UpdateProductTypeAttributeValueUseCaseModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeUseCaseModel {
    
    private Long id;
    private String label;
    private List<UpdateProductTypeAttributeValueUseCaseModel> valueModels;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .label(label)
                .build();
    }
}
