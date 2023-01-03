package com.padr.buynow.outbound.persistence.order.port;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.order.entity.Order;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

@Repository
public interface OrderPersistencePort extends BasePersistencePort<Order> {
    
    List<Order> findByBuyerId(Long buyerId);
}
