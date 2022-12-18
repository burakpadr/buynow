package com.padr.buynow.domain.usecase.address.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.domain.core.address.service.UserAddressService;
import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.address.model.CreateUserAddressModel;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateUserAddress implements BaseUseCase<UserAddress, CreateUserAddressModel> {
    
    private final UserAddressService userAddressService;
    private final UserService userService;

    @Override
    public UserAddress perform(CreateUserAddressModel model) {
        User user = userService.findUserById(model.getUserId());

        UserAddress userAddress = model.to();
        userAddress.setUser(user);

        return userAddressService.createUserAddress(userAddress);
    }

}
