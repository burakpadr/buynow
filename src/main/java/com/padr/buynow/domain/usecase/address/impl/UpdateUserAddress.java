package com.padr.buynow.domain.usecase.address.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.domain.core.address.service.UserAddressService;
import com.padr.buynow.domain.usecase.address.model.UpdateUserAddressModel;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateUserAddress implements BaseUseCase<UserAddress, UpdateUserAddressModel> {
    
    private final UserAddressService userAddressService;

    @Override
    public UserAddress perform(UpdateUserAddressModel model) {
        return userAddressService.updateUserAddress(model.getId(), model.to());
    }
}
