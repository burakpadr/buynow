package com.padr.buynow.domain.core.order.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.order.constant.OrderStep;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    
    @Id
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long id;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStep step;

    @Column
    private Boolean isActive;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
