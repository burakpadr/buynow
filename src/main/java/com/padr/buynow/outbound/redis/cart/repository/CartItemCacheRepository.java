package com.padr.buynow.outbound.redis.cart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.cart.entity.CartItem;

@Repository
public interface CartItemCacheRepository extends CrudRepository<CartItem, String> {
    
    List<CartItem> findByCartId(String cartId);

    void deleteByCartId(String cartId);
}
