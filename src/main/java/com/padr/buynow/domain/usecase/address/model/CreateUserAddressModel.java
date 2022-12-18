package com.padr.buynow.domain.usecase.address.model;

import com.padr.buynow.domain.core.address.entity.UserAddress;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserAddressModel {
    
    private String addressName;
    private String countryName;
    private String stateName;
    private String cityName;
    private Long userId;

    public UserAddress to() {
        return UserAddress.builder()
                .addressName(addressName)
                .countryName(countryName)
                .stateName(stateName)
                .cityName(cityName)
                .build();
    }
}
