package com.padr.buynow.domain.core.shipment.entity;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Shipment extends BaseEntity {

    @Id
    @SequenceGenerator(name = "shipment_id_seq", sequenceName = "shipment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_id_seq")
    private Long id;

    @Column
    private String shipmentNo;

    @Column
    private String shipmentCompanyName;
}
