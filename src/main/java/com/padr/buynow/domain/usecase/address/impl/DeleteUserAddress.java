package com.padr.buynow.domain.usecase.address.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.service.UserAddressService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteUserAddress implements BaseUseCase<Void, Long> {
    
    private final UserAddressService userAddressService;

    @Override
    public Void perform(Long id) {
        userAddressService.delete(id);

        return null;
    }
}
