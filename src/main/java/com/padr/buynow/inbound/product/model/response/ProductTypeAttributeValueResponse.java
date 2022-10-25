package com.padr.buynow.inbound.product.model.response;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeAttributeValueResponse {
    
    private Long id;
    private String value;
    private Boolean isActive;

    public static ProductTypeAttributeValueResponse of(ProductTypeAttributeValue attributeValue) {
        return ProductTypeAttributeValueResponse.builder()
                .id(attributeValue.getId())
                .value(attributeValue.getValue())
                .isActive(attributeValue.getIsActive())
                .build();
    }
}
