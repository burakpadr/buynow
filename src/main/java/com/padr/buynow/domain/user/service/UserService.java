package com.padr.buynow.domain.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Address;
import com.padr.buynow.domain.address.service.AddressService;
import com.padr.buynow.domain.user.entity.User;
import com.padr.buynow.domain.user.exception.UserAlreadyExistWithEmailException;
import com.padr.buynow.domain.user.exception.UserAlreadyExistWithIdentityNumberException;
import com.padr.buynow.domain.user.exception.UserNotFoundException;
import com.padr.buynow.outbound.persistence.user.port.UserPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistencePort userPersistencePort;
    private final AddressService addressService;
    private final PasswordEncoder passwordEncoder;

    public User createUserIfNotExist(User user) {
        userPersistencePort.findByIdentityNumber(user.getIdentityNumber())
                .orElseThrow(UserAlreadyExistWithIdentityNumberException::new);

        userPersistencePort.findByEmail(user.getEmail()).orElseThrow(UserAlreadyExistWithEmailException::new);

        Address address = addressService.createAddress(user.getAddress());

        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddress(address);

        return userPersistencePort.save(user);
    }

    public User findUserById(Long id) {
        return userPersistencePort.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Long id, User updateUser) {
        User user = findUserById(id);

        userPersistencePort.findByEmail(updateUser.getEmail()).ifPresent(u -> {
            if (u.getId() == user.getId())
                throw new UserAlreadyExistWithEmailException();
        });

        addressService.updateAddress(user.getAddress().getId(), updateUser.getAddress());

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
