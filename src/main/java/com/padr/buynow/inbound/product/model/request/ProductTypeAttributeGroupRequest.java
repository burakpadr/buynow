package com.padr.buynow.inbound.product.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeAttributeGroupRequest {
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String label;

    @NotNull
    @Positive
    private Long productTypeId;

    public ProductTypeAttributeGroup to() {
        return ProductTypeAttributeGroup.builder()
                .name(name)
                .label(label)
                .build();
    }
}
