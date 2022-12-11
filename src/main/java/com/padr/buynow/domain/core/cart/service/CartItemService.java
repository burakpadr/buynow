package com.padr.buynow.domain.core.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.cart.constant.CartConstant;
import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.exception.CartItemNotFoundException;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.outbound.redis.cart.port.CartItemCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemCachePort cartItemCachePort;

    public CartItem create(CartItem cartItem) {
        cartItem.setTtl(CartConstant.CART_EXPIRATION_TIME_HOURS);

        return cartItemCachePort.save(cartItem);
    }

    public CartItem findById(String id) {
        return cartItemCachePort.findById(id).orElseThrow(CartItemNotFoundException::new);
    }

    public List<CartItem> findByCartId(String cartId) {
        return cartItemCachePort.findByCartId(cartId);
    }

    public List<CartItem> findByProductId(Long productId) {
        return cartItemCachePort.findByProductId(productId);
    }

    public CartItem update(String cartItemId, Product product) {
        CartItem cartItem = findById(cartItemId);

        cartItem.setSellerTitle(
                String.format("%s %s", product.getOwnerUser().getName(), product.getOwnerUser().getSurname()));
        cartItem.setProductHeader(product.getHeader());
        cartItem.setBasePrice(product.getTraditionalNotice().getBasePrice());
        cartItem.setDiscount(product.getTraditionalNotice().getDiscount().getPercent());

        return cartItemCachePort.save(cartItem);
    }

    public void deleteById(String id) {
        cartItemCachePort.deleteById(id);
    }

    public void deleteByCartId(String cartId) {
        cartItemCachePort.deleteByCartId(cartId);
    }
}
