package com.padr.buynow.inbound.user.model.response;

import java.time.LocalDate;

import com.padr.buynow.domain.core.user.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdate;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getName())
                .email(user.getEmail())
                .birthdate(user.getBirthDate())
                .build();
    } 
}
