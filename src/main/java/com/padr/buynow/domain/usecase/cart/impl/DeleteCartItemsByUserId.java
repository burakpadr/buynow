package com.padr.buynow.domain.usecase.cart.impl;

import com.padr.buynow.domain.core.cart.service.CartItemService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCartItemsByUserId implements BaseUseCase<Void, Long> {

    private final CartItemService cartItemService;

    @Override
    public Void perform(Long userId) {
        cartItemService.deleteByUserId(userId);

        return null;
    }
}
