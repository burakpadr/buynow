package com.padr.buynow.inbound.product.model.response;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.inbound.frontend.model.response.InputFieldTypeResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeAttributeResponse {
    
    private Long id;
    private String name;
    private String label;
    private InputFieldTypeResponse inputFieldType;

    public static ProductTypeAttributeResponse of(ProductTypeAttribute attribute) {
        return ProductTypeAttributeResponse.builder() 
                .id(attribute.getId())
                .name(attribute.getName())
                .label(attribute.getLabel())
                .inputFieldType(InputFieldTypeResponse.of(attribute.getInputFieldType()))
                .build();
    }
}
