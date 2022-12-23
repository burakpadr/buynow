package com.padr.buynow.domain.usecase.notice.model;

import java.math.BigDecimal;

import com.padr.buynow.domain.core.notice.entity.AuctionNotice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuctionNoticeModel {
    
    private BigDecimal basePrice;
    private Long auctionTimeMinutes;
    private Long minimumBidAccrual;
    private Boolean isPublished;
    private Long productId;

    public AuctionNotice to() {
        return AuctionNotice.builder()
                .basePrice(basePrice)
                .auctionTimeMinutes(auctionTimeMinutes)
                .minimumBidAccrual(minimumBidAccrual)
                .isPublished(isPublished)
                .build();
    }
}
