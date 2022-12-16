package com.padr.buynow.inbound.product.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.core.product.entity.ProductType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeRequest {

    @NotNull
    @NotBlank
    private String label;

    private Long parentProductTypeId;

    public ProductType to() {
        return ProductType.builder()
                .label(label)
                .build();
    }
}
