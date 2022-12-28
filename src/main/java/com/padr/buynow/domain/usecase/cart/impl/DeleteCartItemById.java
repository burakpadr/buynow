package com.padr.buynow.domain.usecase.cart.impl;

import com.padr.buynow.domain.core.cart.service.CartItemService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCartItemById implements BaseUseCase<Void, String> {

    private final CartItemService cartItemService;

    @Override
    public Void perform(String id) {
        cartItemService.deleteById(id);

        return null;
    }
}
