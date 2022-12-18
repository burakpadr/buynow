package com.padr.buynow.domain.usecase.address.model;

import com.padr.buynow.domain.core.address.entity.UserAddress;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserAddressModel {

    private Long id;
    private String addressName;
    private String countryName;
    private String stateName;
    private String cityName;

    public UserAddress to() {
        return UserAddress.builder()
                .addressName(addressName)
                .countryName(countryName)
                .stateName(stateName)
                .cityName(cityName)
                .build();
    }
}
