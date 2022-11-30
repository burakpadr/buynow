package com.padr.buynow.inbound.product.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeAttributeRequest {
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String label;

    @NotNull
    private Long inputFieldTypeId;

    public ProductTypeAttribute to() {
        return ProductTypeAttribute.builder()
                .name(name)
                .label(label)
                .build();
    }
}
