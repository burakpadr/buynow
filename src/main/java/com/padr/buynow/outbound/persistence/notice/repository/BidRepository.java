package com.padr.buynow.outbound.persistence.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.notice.entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    
}
