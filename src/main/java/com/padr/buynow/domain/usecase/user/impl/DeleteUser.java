package com.padr.buynow.domain.usecase.user.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteUser implements BaseUseCase<Void, Long> {
    
    private final UserService userService;

    @Override
    public Void perform(Long id) {
        userService.deleteUserById(id);
        return null;
    }
}
