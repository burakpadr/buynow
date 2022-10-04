package com.padr.buynow.inbound.user.controller;

import javax.validation.Valid;

import org.hashids.Hashids;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.padr.buynow.domain.user.entity.User;
import com.padr.buynow.domain.user.port.UserServicePort;
import com.padr.buynow.inbound.user.model.UserRequest;
import com.padr.buynow.inbound.user.model.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class UserController {

    private final UserServicePort userServicePort;
    private final Hashids hashids;

    @PostMapping
    public UserResponse createUserIfNotExist(@Valid @RequestBody UserRequest userRequest) {
        User user = userServicePort.createUserIfNotExist(userRequest.to());

        UserResponse userResponse = UserResponse.of(user);
        userResponse.setId(hashids.encode(user.getId()));

        return userResponse;
    }

    @GetMapping("/id/{encodedUserId}")
    public UserResponse findUserById(@PathVariable String encodedUserId) {
        Long decodedUserId = Long.valueOf(hashids.decode(encodedUserId)[0]);

        User user = userServicePort.findUserById(decodedUserId);

        UserResponse userResponse = UserResponse.of(user);
        userResponse.setId(encodedUserId);

        return userResponse;
    }

    @PutMapping("/id/{encodedUserId}")
    public UserResponse updateUser(@PathVariable String encodedUserId, @Valid @RequestBody UserRequest updateUser) {
        Long decodedUserId = Long.valueOf(hashids.decode(encodedUserId)[0]);

        User user = userServicePort.updateUser(decodedUserId, updateUser.to());

        UserResponse userResponse = UserResponse.of(user);
        userResponse.setId(encodedUserId);

        return userResponse;
    }

    @DeleteMapping("/id/{encodedUserId}")
    public void deleteUserById(@PathVariable String encodedUserId) {
        Long decodedUserId = Long.valueOf(hashids.decode(encodedUserId)[0]);

        userServicePort.deleteUserById(decodedUserId);
    }
}
