package com.padr.buynow.outbound.persistence.order.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.order.entity.Order;
import com.padr.buynow.outbound.persistence.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderPersistencePortImpl implements OrderPersistencePort {
    
    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order t) {
        return orderRepository.save(t);
    }

    @Override
    public List<Order> findByBuyerId(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }
}
