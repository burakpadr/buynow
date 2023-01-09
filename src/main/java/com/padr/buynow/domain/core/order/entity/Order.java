package com.padr.buynow.domain.core.order.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import com.padr.buynow.domain.core.order.constant.OrderStep;
import com.padr.buynow.domain.core.payment.entity.PaymentTransaction;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.shipment.entity.Shipment;
import com.padr.buynow.domain.core.user.entity.User;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    
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
    private User buyer;

    @ManyToOne
    private Product product;

    @OneToOne
    private Shipment shipment;

    @OneToOne
    private PaymentTransaction paymentTransaction;
}
