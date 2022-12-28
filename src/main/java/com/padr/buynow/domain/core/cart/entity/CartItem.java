package com.padr.buynow.domain.core.cart.entity;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("cartItem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    private String id;

    @Indexed
    private Long userId;

    @Indexed
    private Long productId;

    private String sellerTitle;
    private String productHeader;
    private BigDecimal basePrice;
    private BigDecimal discount;

    @TimeToLive(unit = TimeUnit.HOURS)
    private Integer ttl;
}
