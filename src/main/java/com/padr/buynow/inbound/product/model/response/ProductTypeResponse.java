package com.padr.buynow.inbound.product.model.response;

import com.padr.buynow.domain.product.entity.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeResponse {

    private Long id;
    private String name;
    private String label;

    public static ProductTypeResponse of(ProductType productType) {
        return ProductTypeResponse.builder()
                .id(productType.getId())
                .name(productType.getName())
                .label(productType.getLabel())
                .build();
    }
}
