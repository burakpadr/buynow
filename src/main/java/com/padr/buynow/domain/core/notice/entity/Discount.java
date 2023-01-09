package com.padr.buynow.domain.core.notice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "discounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Discount extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "discount_id_seq", sequenceName = "discount_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    private Long id;

    @Column
    private BigDecimal percent;

    @Column
    private Boolean isActive;
}
