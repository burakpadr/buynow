package com.padr.buynow.inbound.address.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.core.address.entity.UserAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotNull
    @NotEmpty
    private String countryName;

    @NotNull
    @NotEmpty
    private String stateName;

    @NotNull
    @NotEmpty
    private String cityName;

    public UserAddress to() {
        return UserAddress.builder()
                .countryName(countryName)
                .stateName(stateName)
                .cityName(cityName)
                .build();
    }
}
