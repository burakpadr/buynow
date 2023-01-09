package com.padr.buynow.domain.core.notice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import com.padr.buynow.domain.core.notice.constant.AuctionNoticeStep;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "auction_notices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AuctionNotice extends BaseEntity {

    @Id
    @SequenceGenerator(name = "auction_notice_id_seq", sequenceName = "auction_notice_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auction_notice_id_seq")
    private Long id;

    @Column
    private BigDecimal basePrice;

    @Column
    private Boolean isPublished;

    @Column
    @Enumerated(EnumType.STRING)
    private AuctionNoticeStep step;

    @Column
    private Long auctionTimeMinutes;

    @Column
    private LocalDateTime startedAt;

    @Column
    private LocalDateTime originalExpireAt;

    @Column
    private LocalDateTime expiredAt;

    @Column
    private Long minimumBidAccrual;

    @Column
    private Boolean isActive;

    @Column
    private String cancellationReason;

    @OneToMany(mappedBy = "auctionNotice", fetch = FetchType.LAZY)
    private List<Bid> bids;
}
