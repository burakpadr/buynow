package com.padr.buynow.domain.usecase.cart.impl;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.service.CartItemService;
import com.padr.buynow.domain.usecase.cart.model.CreateCartItemModel;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCartItem implements BaseUseCase<CartItem, CreateCartItemModel> {

    private final CartItemService cartItemService;

    @Override
    public CartItem perform(CreateCartItemModel createCartItemModel) {
        return cartItemService.create(createCartItemModel.to());
    }
}
