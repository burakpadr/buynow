package com.padr.buynow.inbound.attribute.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.product.entity.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeRequest {
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String label;

    @NotNull
    private Long inputFieldTypeId;

    public Attribute to() {
        return Attribute.builder()
                .name(name)
                .label(label)
                .build();
    }
}
