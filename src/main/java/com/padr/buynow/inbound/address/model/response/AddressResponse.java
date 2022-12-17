package com.padr.buynow.inbound.address.model.response;

import com.padr.buynow.domain.core.address.entity.UserAddress;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private Long id;
    private String countryName;
    private String stateName;
    private String cityName;

    public static AddressResponse of(UserAddress address) {
        return AddressResponse.builder()
                .id(address.getId())
                .countryName(address.getCountryName())
                .stateName(address.getStateName())
                .cityName(address.getCityName())
                .build();
    }
}
