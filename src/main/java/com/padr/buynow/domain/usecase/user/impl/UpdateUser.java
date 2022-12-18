package com.padr.buynow.domain.usecase.user.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.user.model.UpdateUserModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateUser implements BaseUseCase<User, UpdateUserModel> {
    
    private UserService userService;

    @Override
    public User perform(UpdateUserModel model) {
        return userService.updateUser(model.getId(), model.to());
    }
}
