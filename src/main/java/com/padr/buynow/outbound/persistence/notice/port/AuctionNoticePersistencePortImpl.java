package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.notice.entity.AuctionNotice;
import com.padr.buynow.outbound.persistence.notice.repository.AuctionNoticeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuctionNoticePersistencePortImpl implements AuctionNoticePersistencePort {
    
    private final AuctionNoticeRepository auctionNoticeRepository;

    @Override
    public Optional<AuctionNotice> findById(Long id) {
        return auctionNoticeRepository.findById(id);
    }

    @Override
    public AuctionNotice save(AuctionNotice auctionNotice) {
        return auctionNoticeRepository.save(auctionNotice);
    }
}
