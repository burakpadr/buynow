package com.padr.buynow.domain.core.notice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.constant.AuctionNoticeStep;
import com.padr.buynow.domain.core.notice.entity.AuctionNotice;
import com.padr.buynow.domain.core.notice.exception.AuctionNoticeNotFoundException;
import com.padr.buynow.domain.core.notice.exception.NoticeIsLiveException;
import com.padr.buynow.domain.core.notice.exception.NoticeIsNotLiveException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeInNoticeException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeInCargoException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBePreparingCargoException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeWaitingForBidException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeWaitingForPaymentException;
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
            auctionNotice.setIsPublished(updateAuctionNotice.getIsPublished());

            return auctionNoticePersistencePort.save(auctionNotice);
        } else
            throw new StepShouldBeWaitingForBidException();
    }

    public void deleteById(Long id) {
        AuctionNotice auctionNotice = findById(id);

        auctionNotice.setIsActive(false);

        auctionNoticePersistencePort.save(auctionNotice);
    }

    public void startTheAuction(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.WAITING_FOR_BID)) {
                auctionNotice.setStartedAt(LocalDateTime.now());
                auctionNotice.setExpiredAt(LocalDateTime.now().plusMinutes(auctionNotice.getAuctionTimeMinutes()));
                auctionNotice
                        .setOriginalExpireAt(LocalDateTime.now().plusMinutes(auctionNotice.getAuctionTimeMinutes()));
                auctionNotice.setStep(AuctionNoticeStep.IN_AUCTION);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBeWaitingForBidException();
        } else
            throw new NoticeIsNotLiveException();
    }

    public void finishTheAuction(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.IN_AUCTION)) {
                auctionNotice.setIsPublished(false);
                auctionNotice.setStep(AuctionNoticeStep.WAITING_FOR_PAYMENT);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBeInNoticeException();
        } else
            throw new NoticeIsNotLiveException();
    }

    public void prepareTheCargo(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (!auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.WAITING_FOR_PAYMENT)) {
                auctionNotice.setStep(AuctionNoticeStep.PREPARING_CARGO);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBeWaitingForPaymentException();
        } else
            throw new NoticeIsLiveException();
    }

    public void shipTheProduct(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (!auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.PREPARING_CARGO)) {
                auctionNotice.setStep(AuctionNoticeStep.IN_CARGO);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBePreparingCargoException();
        } else
            throw new NoticeIsLiveException();
    }

    public void completeTheAuction(Long id) {
        AuctionNotice auctionNotice = findById(id);

        if (!auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.IN_CARGO)) {
                auctionNotice.setStep(AuctionNoticeStep.SOLD);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBeInCargoException();
        } else
            throw new NoticeIsLiveException();
    }

    public void cancelTheAuction(Long id, String cancellationReason) {
        AuctionNotice auctionNotice = findById(id);

        if (!auctionNotice.getIsPublished()) {
            if (auctionNotice.getStep().equals(AuctionNoticeStep.WAITING_FOR_PAYMENT)) {
                auctionNotice.setStep(AuctionNoticeStep.CANCELLED);
                auctionNotice.setCancellationReason(cancellationReason);

                auctionNoticePersistencePort.save(auctionNotice);
            } else
                throw new StepShouldBeWaitingForPaymentException();
        } else
            throw new NoticeIsLiveException();
    }
}
