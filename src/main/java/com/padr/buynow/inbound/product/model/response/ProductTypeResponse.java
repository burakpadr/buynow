package com.padr.buynow.inbound.product.model.response;

import java.util.List;
import java.util.stream.Collectors;

import com.padr.buynow.domain.core.product.entity.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeResponse {

    private Long id;
    private String label;
    private Boolean isActive;
    private List<ProductTypeAttributeGroupResponse> productTypeAttributeGroups;

    public static ProductTypeResponse of(ProductType productType) {
        return ProductTypeResponse.builder()
                .id(productType.getId())
                .label(productType.getLabel())
                .isActive(productType.getIsActive())
                .productTypeAttributeGroups(productType.getProductTypeAttributeGroups().stream()
                        .map(ProductTypeAttributeGroupResponse::of).collect(Collectors.toList()))
                .build();
    }
}
