package com.padr.buynow.domain.usecase.user.model;

import java.time.LocalDate;

import com.padr.buynow.domain.core.user.entity.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateUserModel {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;

    public User to() {
        return User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .birthDate(birthDate)
                .build();
    }
}
