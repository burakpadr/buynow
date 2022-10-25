package com.padr.buynow.inbound.attribute.model.response;

import com.padr.buynow.domain.product.entity.Attribute;
import com.padr.buynow.inbound.frontend.model.response.InputFieldTypeResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeResponse {
    
    private Long id;
    private String name;
    private String label;
    private InputFieldTypeResponse inputFieldType;

    public static AttributeResponse of(Attribute attribute) {
        return AttributeResponse.builder() 
                .id(attribute.getId())
                .name(attribute.getName())
                .label(attribute.getLabel())
                .inputFieldType(InputFieldTypeResponse.of(attribute.getInputFieldType()))
                .build();
    }
}
