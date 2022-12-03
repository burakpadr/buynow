package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.Bid;
import com.padr.buynow.outbound.persistence.notice.repository.BidRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BidPersistencePortImpl implements BidPersistencePort {
    
    private final BidRepository bidRepository;

    @Override
    public Optional<Bid> findById(Long id) {
        return bidRepository.findById(id);
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
}
