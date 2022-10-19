package com.padr.buynow.inbound.attribute.model.response;

import com.padr.buynow.domain.attribute.entity.AttributeValue;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeValueResponse {
    
    private Long id;
    private String value;
    private Boolean isActive;

    public static AttributeValueResponse of(AttributeValue attributeValue) {
        return AttributeValueResponse.builder()
                .id(attributeValue.getId())
                .value(attributeValue.getValue())
                .isActive(attributeValue.getIsActive())
                .build();
    }
}
