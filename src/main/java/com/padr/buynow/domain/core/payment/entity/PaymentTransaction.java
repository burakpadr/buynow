package com.padr.buynow.domain.core.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "payment_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentTransaction {

    @Id
    @SequenceGenerator(name = "payment_transaction_id_seq", sequenceName = "payment_transaction_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_transaction_id_seq")
    private Long id;

    @Column
    private String paymentId;

    @Column
    private String paymentTransactionId;

    @Column
    private String ipAddress;
}
