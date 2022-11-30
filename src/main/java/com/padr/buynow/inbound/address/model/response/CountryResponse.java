package com.padr.buynow.inbound.address.model.response;

import com.padr.buynow.domain.core.address.entity.Country;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryResponse {

    private Long id;
    private String name;
    private String iso;

    public static CountryResponse of(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .iso(country.getIso())
                .build();
    }
}
