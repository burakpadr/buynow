package com.padr.buynow.inbound.product.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeAttributeValueRequest {
    
    @NotNull
    @NotEmpty
    private String value;

    @NotNull
    @Positive
    private Long attributeId;

    public ProductTypeAttributeValue to() {
        return ProductTypeAttributeValue.builder()
                .value(value)
                .build();
    }
}
