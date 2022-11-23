package com.padr.buynow.domain.notice.entity;

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
@Table(name = "auction_notice_cancellations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuctionNoticeCancellation {

    @Id
    @SequenceGenerator(name = "auction_notice_cancellation_id_seq", sequenceName = "auction_notice_cancellation_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auction_notice_cancellation_id_seq")
    private Long id;

    @Column
    private String reason;

    @Column
    private Boolean isActive;
}
