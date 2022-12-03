package com.padr.buynow.domain.core.notice.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.entity.Bid;
import com.padr.buynow.domain.core.notice.exception.BidNotFoundException;
import com.padr.buynow.outbound.persistence.notice.port.BidPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidService {
    
    private final BidPersistencePort bidPersistencePort;

    public Bid create(Bid bid) {
        return bidPersistencePort.save(bid);
    }

    public Bid findById(Long id) {
        return bidPersistencePort.findById(id).orElseThrow(BidNotFoundException::new);
    }

    public Bid update(Long id, Bid updateBid) {
        Bid bid = findById(id);

        bid.setValue(updateBid.getValue());

        return bidPersistencePort.save(bid);
    }

    public void delete(Long id) {
        Bid bid = findById(id);

        bid.setIsActive(false);

        bidPersistencePort.save(bid);
    }
}
