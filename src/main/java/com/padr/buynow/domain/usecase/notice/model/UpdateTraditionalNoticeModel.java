package com.padr.buynow.domain.usecase.notice.model;

import java.math.BigDecimal;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTraditionalNoticeModel {
    
    private Long id;
    private Long productId;
    private BigDecimal basePrice;
    private Boolean isPublished;
    private UpdateDiscountModel updateDiscountModel;

    public TraditionalNotice to() {
        return TraditionalNotice.builder()
                .basePrice(basePrice)
                .isPublished(isPublished)
                .build();
    } 
}
