package com.padr.buynow.outbound.redis.cart.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.core.cart.entity.CartItem;

public interface CartItemCachePort {

    Optional<CartItem> findById(String id);

    List<CartItem> findByCartId(String cartId);

    List<CartItem> findByProductId(Long productId);

    CartItem save(CartItem cartItem);

    void deleteById(String id);

    void deleteByCartId(String cartId);
}
