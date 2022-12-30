package com.padr.buynow.domain.usecase.notice.impl;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.service.CartItemService;
import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.Discount;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.notice.service.DiscountService;
import com.padr.buynow.domain.core.notice.service.TraditionalNoticeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.notice.model.UpdateTraditionalNoticeModel;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateTraditionalNotice implements BaseUseCase<TraditionalNotice, UpdateTraditionalNoticeModel> {

    private final TraditionalNoticeService traditionalNoticeService;
    private final DiscountService discountService;
    private final CartItemService cartItemService;


    @Override
    public TraditionalNotice perform(UpdateTraditionalNoticeModel model) {
        TraditionalNotice traditionalNotice = traditionalNoticeService.findById(model.getId());
        Discount discount = discountService.findById(model.getUpdateDiscountModel().getId());

        discountService.update(discount.getId(), model.getUpdateDiscountModel().to());

        TraditionalNotice updatedTraditionalNotice = traditionalNoticeService.update(traditionalNotice.getId(), model.to());

        notifyObservers(model.getProductId(), updatedTraditionalNotice);

        return updatedTraditionalNotice;
    }

    private void notifyObservers(Long productId, TraditionalNotice traditionalNotice) {
        List<CartItem> cartItems = cartItemService.findByProductId(productId);

        cartItems.stream().parallel().forEach(cartItem -> {
            cartItemService.updateFromTraditionalNotice(cartItem.getId(), traditionalNotice);
        });
    }
}
