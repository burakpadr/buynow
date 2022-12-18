package com.padr.buynow.inbound.user.model.request;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.inbound.address.model.request.AddressRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    private AddressRequest address;

    public User to() {
        return User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .birthDate(birthdate)
                .address(address.to())
                .build();
    }
}
