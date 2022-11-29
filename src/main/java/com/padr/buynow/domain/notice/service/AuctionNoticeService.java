package com.padr.buynow.domain.notice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.notice.constant.AuctionNoticeStep;
import com.padr.buynow.domain.notice.entity.AuctionNotice;
import com.padr.buynow.domain.notice.exception.AuctionNoticeNotFoundException;
import com.padr.buynow.domain.notice.exception.NoticeIsNotLiveException;
import com.padr.buynow.domain.notice.exception.AuctionHasAlreadyStartedException;
import com.padr.buynow.outbound.persistence.notice.port.AuctionNoticePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuctionNoticeService {

    private final AuctionNoticePersistencePort auctionNoticePersistencePort;

    public AuctionNotice create(AuctionNotice auctionNotice) {
        auctionNotice.setStep(AuctionNoticeStep.WAITING_FOR_BID);
        auctionNotice.setIsActive(true);

        return auctionNoticePersistencePort.save(auctionNotice);
    }

    public AuctionNotice findById(Long id) {
        return auctionNoticePersistencePort.findById(id).orElseThrow(AuctionNoticeNotFoundException::new);
    }

    public AuctionNotice update(Long id, AuctionNotice updateAuctionNotice) {
        AuctionNotice auctionNotice = findById(id);

        if (auctionNotice.getStep().equals(AuctionNoticeStep.WAITING_FOR_BID)) {
            auctionNotice.setBasePrice(updateAuctionNotice.getBasePrice());
            auctionNotice.setAuctionTimeMinutes(updateAuctionNotice.getAuctionTimeMinutes());
            auctionNotice.setMinimumBidAccrual(updateAuctionNotice.getMinimumBidAccrual());

            return auctionNoticePersistencePort.save(auctionNotice);
        }
        else
            throw new AuctionHasAlreadyStartedException();
    }

    public void deleteById(Long id) {
        AuctionNotice auctionNotice = findById(id);

        auctionNotice.setIsActive(false);

        auctionNoticePersistencePort.save(auctionNotice);
    }

    public AuctionNotice startAuction(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.WAITING_FOR_BID)) {
                auctionNotice.setStartedAt(LocalDateTime.now());
                auctionNotice.setExpiredAt(LocalDateTime.now().plusMinutes(auctionNotice.getAuctionTimeMinutes()));
                auctionNotice.setOriginalExpireAt(LocalDateTime.now().plusMinutes(auctionNotice.getAuctionTimeMinutes()));
                auctionNotice.setStep(AuctionNoticeStep.IN_AUCTION);

                return auctionNoticePersistencePort.save(auctionNotice);
            }
            else
                throw new AuctionHasAlreadyStartedException();
        }   
        else
            throw new NoticeIsNotLiveException();
    }
}
