package com.padr.buynow.domain.usecase.cart.model;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreateCartItemModel {

    private Long userId;
    private Long productId;
    private String sellerTitle;
    private String productHeader;
    private BigDecimal basePrice;
    private BigDecimal discount;

    public CartItem to() {
        return CartItem.builder()
                .userId(userId)
                .productId(productId)
                .sellerTitle(sellerTitle)
                .productHeader(productHeader)
                .basePrice(basePrice)
                .discount(discount)
                .build();
    }
}
