package com.padr.buynow.domain.usecase.product.producttypeattributevalue.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductTypeAttributeValueUseCaseModel {

    private Long id;
    private ProductTypeAttributeValueUseCaseModel updateProductTypeAttributeValueModel;
}
