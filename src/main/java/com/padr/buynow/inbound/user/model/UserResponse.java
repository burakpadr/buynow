package com.padr.buynow.inbound.user.model;

import java.time.LocalDate;

import com.padr.buynow.domain.user.entity.User;
import com.padr.buynow.inbound.address.model.AddressResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    
    private Long id;
    private String name;
    private String surname;
    private String identityNumber;
    private String email;
    private LocalDate birthdate;
    private AddressResponse address;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getName())
                .identityNumber(user.getIdentityNumber())
                .email(user.getEmail())
                .birthdate(user.getBirthDate())
                .address(AddressResponse.of(user.getAddress()))
                .build();
    } 
}
