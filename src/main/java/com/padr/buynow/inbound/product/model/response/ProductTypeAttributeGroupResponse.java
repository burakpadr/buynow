package com.padr.buynow.inbound.product.model.response;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeAttributeGroupResponse {
    
    private Long id;
    private String name;
    private String label;
    private Boolean isActive;

    public static ProductTypeAttributeGroupResponse of(ProductTypeAttributeGroup productTypeAttributeGroup) {
        return ProductTypeAttributeGroupResponse.builder()
                .id(productTypeAttributeGroup.getId())
                .name(productTypeAttributeGroup.getName())
                .label(productTypeAttributeGroup.getLabel())
                .isActive(productTypeAttributeGroup.getIsActive())
                .build();
    }
}
