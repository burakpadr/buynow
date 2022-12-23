package com.padr.buynow.domain.usecase.notice.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.constant.NoticeType;
import com.padr.buynow.domain.core.notice.entity.Discount;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.notice.service.DiscountService;
import com.padr.buynow.domain.core.notice.service.TraditionalNoticeService;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.notice.model.CreateTraditionalNoticeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateTraditionalNotice implements BaseUseCase<TraditionalNotice, CreateTraditionalNoticeModel> {

    private TraditionalNoticeService traditionalNoticeService;
    private DiscountService discountService;
    private ProductService productService;

    @Override
    public TraditionalNotice perform(CreateTraditionalNoticeModel model) {
        Discount discount = discountService.create(model.getCreateDiscountModel().to());

        TraditionalNotice traditionalNotice = model.to();
        traditionalNotice.setDiscount(discount);

        TraditionalNotice savedTraditionalNotice = traditionalNoticeService.create(traditionalNotice);

        Product product = productService.findById(model.getProductId());
        product.setNoticeType(NoticeType.TRADITIONAL_NOTICE);
        product.setTraditionalNotice(savedTraditionalNotice);

        productService.update(product.getId(), product);

        return savedTraditionalNotice;
    }
}
