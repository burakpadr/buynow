package com.padr.buynow.domain.core.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.exception.UserAlreadyExistWithEmailException;
import com.padr.buynow.domain.core.user.exception.UserNotFoundException;
import com.padr.buynow.outbound.persistence.user.port.UserPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        userPersistencePort.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new UserAlreadyExistWithEmailException();
        });

        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userPersistencePort.save(user);
    }

    public User findUserById(Long id) {
        return userPersistencePort.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Long id, User updateUser) {
        User user = findUserById(id);

        userPersistencePort.findByEmail(updateUser.getEmail()).ifPresent(u -> {
            if (u.getId() != user.getId())
                throw new UserAlreadyExistWithEmailException();
        });

        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setEmail(updateUser.getEmail());
        user.setBirthDate(updateUser.getBirthDate());

        return userPersistencePort.save(user);
    }

    public void deleteUserById(Long id) {
        User user = findUserById(id);

        user.setIsActive(false);

        userPersistencePort.save(user);
    }
}
