package com.padr.buynow.domain.core.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.order.entity.Order;
import com.padr.buynow.domain.core.order.exception.OrderNotFoundException;
import com.padr.buynow.outbound.persistence.order.port.OrderPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderPersistencePort orderPersistencePort;

    public Order create(Order order) {
        order.setIsActive(true);

        return orderPersistencePort.save(order);
    }

    public Order findById(Long id) {
        return orderPersistencePort.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> findOrderByBuyerId(Long buyerId) {
        return orderPersistencePort.findByBuyerId(buyerId);
    }

    public void delete(Long id) {
        Order order = findById(id);

        order.setIsActive(false);

        orderPersistencePort.save(order);
    }
}
