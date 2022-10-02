package com.padr.buynow.inbound.address.model;

import com.padr.buynow.domain.address.entity.Country;

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
