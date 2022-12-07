package com.padr.buynow.domain.core.notice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "traditional_notices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraditionalNotice {
    
    @Id
    @SequenceGenerator(name = "traditional_notice_id_seq", sequenceName = "traditional_notice_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traditional_notice_id_seq")
    private Long id;

    @Column
    private BigDecimal price;

    @Column
    private Boolean isPublished;

    @Column Boolean isActive;
}
