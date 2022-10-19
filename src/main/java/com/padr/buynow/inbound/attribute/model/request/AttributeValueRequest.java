package com.padr.buynow.inbound.attribute.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.padr.buynow.domain.attribute.entity.AttributeValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeValueRequest {
    
    @NotNull
    @NotEmpty
    private String value;

    @NotNull
    @Positive
    private Long attributeId;

    public AttributeValue to() {
        return AttributeValue.builder()
                .value(value)
                .build();
    }
}
