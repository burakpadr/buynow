package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import com.padr.buynow.domain.core.notice.entity.Bid;

public interface BidPersistencePort {
    
    Optional<Bid> findById(Long id);

    Bid save(Bid bid);
}
