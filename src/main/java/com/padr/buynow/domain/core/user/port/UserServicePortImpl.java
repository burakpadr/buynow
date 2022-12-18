package com.padr.buynow.domain.core.user.port;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServicePortImpl implements UserServicePort {
    
    private final UserService userService;

    @Override
    public User createUserIfNotExist(User user) {
        return userService.createUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userService.findUserById(id);
    }

    @Override
    public User updateUser(Long id, User updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
        
    }
}
