package com.padr.buynow.domain.usecase.address.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.domain.core.address.service.UserAddressService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindUserAddressById implements BaseUseCase<UserAddress, Long> {
    
    private final UserAddressService userAddressService;

    @Override
    public UserAddress perform(Long id) {
        return userAddressService.findUserAddressById(id);
    }
}
