package com.padr.buynow.domain.core.user.port;

import com.padr.buynow.domain.core.user.entity.User;

public interface UserServicePort {
    
    User createUserIfNotExist(User user);

    User findUserById(Long id);

    User updateUser(Long id, User updateUser);

    void deleteUserById(Long id);
}
