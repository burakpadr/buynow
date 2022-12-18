package com.padr.buynow.domain.usecase.user.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.user.model.CreateUserModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateUser implements BaseUseCase<User, CreateUserModel> {
    
    private final UserService userService;

    @Override
    public User perform(CreateUserModel model) {
        return userService.createUser(model.to());
    }
}
