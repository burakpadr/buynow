package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import com.padr.buynow.domain.core.notice.entity.AuctionNotice;

public interface AuctionNoticePersistencePort {
    
    Optional<AuctionNotice> findById(Long id);

    AuctionNotice save(AuctionNotice auctionNotice);
}
