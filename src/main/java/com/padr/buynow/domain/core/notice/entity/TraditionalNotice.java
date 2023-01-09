package com.padr.buynow.domain.core.notice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "traditional_notices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TraditionalNotice extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "traditional_notice_id_seq", sequenceName = "traditional_notice_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traditional_notice_id_seq")
    private Long id;

    @Column
    private BigDecimal basePrice;

    @Column
    private Boolean isPublished;

    @Column 
    private Boolean isActive;

    @OneToOne
    private Discount discount;
}
