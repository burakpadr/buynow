package com.padr.buynow.outbound.redis.cart.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.cart.entity.Cart;
import com.padr.buynow.outbound.redis.cart.repository.CartCacheRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartCachePortImpl implements CartCachePort {
    
    private final CartCacheRepository cartCacheRepository;

    @Override
    public Optional<Cart> findById(String id) {
        return cartCacheRepository.findById(id);
    }

    @Override
    public Optional<Cart> findByUserId(Long userId) {
        return cartCacheRepository.findByUserId(userId);
    }

    @Override
    public Cart save(Cart cart) {
        return cartCacheRepository.save(cart);
    }

    @Override
    public void deleteById(String id) {
        cartCacheRepository.deleteById(id);
    }
}
