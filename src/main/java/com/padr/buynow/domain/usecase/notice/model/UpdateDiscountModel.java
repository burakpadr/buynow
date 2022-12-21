package com.padr.buynow.domain.usecase.notice.model;

import java.math.BigDecimal;

import com.padr.buynow.domain.core.notice.entity.Discount;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDiscountModel {
    
    private Long id;
    private BigDecimal percent;

    public Discount to() {
        return Discount.builder()
                .percent(percent)
                .build();
    }
}
