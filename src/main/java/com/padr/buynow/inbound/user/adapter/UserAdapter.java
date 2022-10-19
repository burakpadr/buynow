package com.padr.buynow.inbound.user.adapter;

import javax.validation.Valid;

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

import com.padr.buynow.domain.user.port.UserServicePort;
import com.padr.buynow.inbound.user.model.request.UserRequest;
import com.padr.buynow.inbound.user.model.response.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class UserAdapter {

    private final UserServicePort userServicePort;

    @PostMapping
    public UserResponse createUserIfNotExist(@Valid @RequestBody UserRequest userRequest) {
        return UserResponse.of(userServicePort.createUserIfNotExist(userRequest.to()));
    }

    @GetMapping("/{userId}")
    public UserResponse findUserById(@PathVariable Long userId) {
        return UserResponse.of(userServicePort.findUserById(userId));
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable Long userId, @Valid @RequestBody UserRequest updateUser) {
        return UserResponse.of(userServicePort.updateUser(userId, updateUser.to()));
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userServicePort.deleteUserById(userId);
    }
}
