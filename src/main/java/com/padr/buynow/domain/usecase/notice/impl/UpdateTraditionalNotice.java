package com.padr.buynow.domain.usecase.notice.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.Discount;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.notice.service.DiscountService;
import com.padr.buynow.domain.core.notice.service.TraditionalNoticeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.notice.model.UpdateTraditionalNoticeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateTraditionalNotice implements BaseUseCase<TraditionalNotice, UpdateTraditionalNoticeModel> {

    private TraditionalNoticeService traditionalNoticeService;
    private DiscountService discountService;

    @Override
    public TraditionalNotice perform(UpdateTraditionalNoticeModel model) {
        TraditionalNotice traditionalNotice = traditionalNoticeService.findById(model.getId());
        Discount discount = discountService.findById(model.getUpdateDiscountModel().getId());

        discountService.update(discount.getId(), model.getUpdateDiscountModel().to());

        return traditionalNoticeService.update(traditionalNotice.getId(), model.to());

    }
}
