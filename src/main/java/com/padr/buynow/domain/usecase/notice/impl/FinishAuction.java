package com.padr.buynow.domain.usecase.notice.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.service.AuctionNoticeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FinishAuction implements BaseUseCase<Void, Long> {

    private final AuctionNoticeService auctionNoticeService;

    @Override
    public Void perform(Long id) {
        auctionNoticeService.finishTheAuction(id);

        return null;
    }
}
