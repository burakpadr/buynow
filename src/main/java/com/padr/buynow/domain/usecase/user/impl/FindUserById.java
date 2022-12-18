package com.padr.buynow.domain.usecase.user.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindUserById implements BaseUseCase<User, Long> {
    
    private final UserService userService;

    @Override
    public User perform(Long id) {
        return userService.findUserById(id);
    }
}
