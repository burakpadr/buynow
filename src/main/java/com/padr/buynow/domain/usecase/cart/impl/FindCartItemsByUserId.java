package com.padr.buynow.domain.usecase.cart.impl;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.service.CartItemService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindCartItemsByUserId implements BaseUseCase<List<CartItem>, Long> {

    private final CartItemService cartItemService;

    @Override
    public List<CartItem> perform(Long userId) {
        return cartItemService.findByUserId(userId);
    }
}
