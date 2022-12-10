package com.padr.buynow.outbound.persistence.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padr.buynow.domain.core.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findByUserId(Long userId);
}
