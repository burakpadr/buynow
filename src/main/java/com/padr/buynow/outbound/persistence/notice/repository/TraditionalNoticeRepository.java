package com.padr.buynow.outbound.persistence.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;

@Repository
public interface TraditionalNoticeRepository extends JpaRepository<TraditionalNotice, Long> {
    
}
