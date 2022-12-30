package com.padr.buynow.domain.core.cart.service;

import java.util.List;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
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

    public List<CartItem> findByUserId(Long userId) {
        return cartItemCachePort.findByUserId(userId);
    }

    public List<CartItem> findByProductId(Long productId) {
        return cartItemCachePort.findByProductId(productId);
    }

    public void updateFromProduct(String cartItemId, Product product) {
        CartItem cartItem = findById(cartItemId);

//        cartItem.setSellerTitle(
//                String.format("%s %s", product.getOwnerUser().getName(), product.getOwnerUser().getSurname()));
        cartItem.setProductHeader(product.getHeader());
    }

    public void updateFromTraditionalNotice(String cartItemId, TraditionalNotice traditionalNotice) {
        CartItem cartItem = findById(cartItemId);

        cartItem.setBasePrice(traditionalNotice.getBasePrice());
        cartItem.setDiscount(traditionalNotice.getDiscount().getPercent());
    }

    public void deleteById(String id) {
        cartItemCachePort.deleteById(id);
    }

    public void deleteByUserId(Long userId) {
        cartItemCachePort.deleteByUserId(userId);
    }
}
