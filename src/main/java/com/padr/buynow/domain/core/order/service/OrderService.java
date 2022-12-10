package com.padr.buynow.domain.core.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.order.constant.OrderStep;
import com.padr.buynow.domain.core.order.entity.Order;
import com.padr.buynow.domain.core.order.exception.OrderNotFoundException;
import com.padr.buynow.domain.core.order.exception.StepShouldBeInCargoException;
import com.padr.buynow.domain.core.order.exception.StepShouldBePreparingCargoException;
import com.padr.buynow.outbound.persistence.order.port.OrderPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderPersistencePort orderPersistencePort;

    public Order create(Order order) {
        order.setIsActive(true);
        order.setStep(OrderStep.PREPARING_CARGO);

        return orderPersistencePort.save(order);
    }

    public Order findById(Long id) {
        return orderPersistencePort.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> findByUserId(Long userId) {
        return orderPersistencePort.findByUserId(userId);
    }

    public void shipItTheOrder(Long id) {
        Order order = findById(id);

        if (order.getStep().equals(OrderStep.PREPARING_CARGO)) {
            order.setStep(OrderStep.IN_CARGO);

            orderPersistencePort.save(order);
        }
        else
            throw new StepShouldBePreparingCargoException();
    }

    public void completeTheOrder(Long id) {
        Order order = findById(id);

        if (order.getStep().equals(OrderStep.IN_CARGO)) {
            order.setStep(OrderStep.SOLD);

            orderPersistencePort.save(order);
        }
        else
            throw new StepShouldBeInCargoException();
    }

    public void delete(Long id) {
        Order order = findById(id);

        order.setIsActive(false);

        orderPersistencePort.save(order);
    }
}
