package com.padr.buynow.outbound.redis.cart.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.outbound.redis.cart.repository.CartItemCacheRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartItemCachePortImpl implements CartItemCachePort {
    
    private final CartItemCacheRepository cartItemCacheRepository;

    @Override
    public List<CartItem> findByCartId(String cartId) {
        return cartItemCacheRepository.findByCartId(cartId);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemCacheRepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> findById(String id) {
        return cartItemCacheRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        cartItemCacheRepository.deleteById(id);
    }

    @Override
    public void deleteByCartId(String cartId) {
        cartItemCacheRepository.deleteByCartId(null);
    }

    @Override
    public List<CartItem> findByProductId(Long productId) {
        return cartItemCacheRepository.findByProductId(productId);
    }
}
