package com.padr.buynow.outbound.redis.cart.port;

import java.util.Optional;

import com.padr.buynow.domain.core.cart.entity.Cart;

public interface CartCachePort  {

    Optional<Cart> findById(String id);

    Optional<Cart> findByUserId(Long userId);

    Cart save(Cart cart);

    void deleteById(String id);
}
