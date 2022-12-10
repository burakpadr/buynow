package com.padr.buynow.domain.core.cart.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.cart.entity.Cart;
import com.padr.buynow.domain.core.cart.exception.CartNotFoundException;
import com.padr.buynow.outbound.redis.cart.port.CartCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartCachePort cartCachePort;

    public Cart create(Cart cart) {
        return cartCachePort.save(cart);
    }

    public Cart findById(String id) {
        return cartCachePort.findById(id).orElseThrow(CartNotFoundException::new);
    }

    public Cart findByUserId(Long userId) {
        return cartCachePort.findByUserId(userId).orElseThrow(CartNotFoundException::new);
    }

    public void deleteById(String id) {
        cartCachePort.deleteById(id);
    }
}
