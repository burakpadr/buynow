package com.padr.buynow.domain.core.shipment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @SequenceGenerator(name = "shipment_id_seq", sequenceName = "shipment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_id_seq")
    private Long id;

    @Column
    private String shipmentNo;

    @Column
    private String shipmentCompanyName;
}
