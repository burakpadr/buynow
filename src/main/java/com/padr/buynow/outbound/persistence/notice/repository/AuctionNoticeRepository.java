package com.padr.buynow.outbound.persistence.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.notice.entity.AuctionNotice;

@Repository
public interface AuctionNoticeRepository extends JpaRepository<AuctionNotice, Long> {
    
}
