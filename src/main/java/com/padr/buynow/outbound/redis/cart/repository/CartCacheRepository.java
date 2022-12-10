package com.padr.buynow.outbound.redis.cart.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.cart.entity.Cart;

@Repository
public interface CartCacheRepository extends CrudRepository<Cart, String> {
    
    Optional<Cart> findByUserId(Long userId);
}
