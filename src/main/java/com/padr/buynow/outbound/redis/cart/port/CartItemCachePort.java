package com.padr.buynow.outbound.redis.cart.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.cart.entity.CartItem;

public interface CartItemCachePort {

    Optional<CartItem> findById(String id);

    List<CartItem> findByUserId(Long userId);

    List<CartItem> findByProductId(Long productId);

    CartItem save(CartItem cartItem);

    void deleteById(String id);

    void deleteByUserId(Long userId);
}
