package com.padr.buynow.domain.usecase.notice.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.AuctionNotice;
import com.padr.buynow.domain.core.notice.service.AuctionNoticeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.notice.model.UpdateAuctionNoticeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateAuctionNotice implements BaseUseCase<AuctionNotice, UpdateAuctionNoticeModel> {

    private final AuctionNoticeService auctionNoticeService;

    @Override
    public AuctionNotice perform(UpdateAuctionNoticeModel model) {
        return auctionNoticeService.update(model.getId(), model.to());
    }
}
