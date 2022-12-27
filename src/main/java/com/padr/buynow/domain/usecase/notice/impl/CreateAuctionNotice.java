package com.padr.buynow.domain.usecase.notice.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.AuctionNotice;
import com.padr.buynow.domain.core.notice.service.AuctionNoticeService;
import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.notice.model.CreateAuctionNoticeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateAuctionNotice implements BaseUseCase<AuctionNotice, CreateAuctionNoticeModel> {

    private final AuctionNoticeService auctionNoticeService;
    private final ProductService productService;

    @Override
    public AuctionNotice perform(CreateAuctionNoticeModel model) {
        AuctionNotice auctionNotice = auctionNoticeService.create(model.to());

        productService.setAuctionNotice(model.getProductId(), auctionNotice);

        return auctionNotice;
    }
}
