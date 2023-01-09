package com.padr.buynow.domain.core.notice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import com.padr.buynow.domain.core.user.entity.User;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "bids")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Bid extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "bid_id_seq", sequenceName = "bid_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_id_seq")
    private Long id;

    @Column
    private BigDecimal value;

    @Column
    private Boolean isActive;

    @ManyToOne
    private AuctionNotice auctionNotice;

    @ManyToOne
    private User user;
}
