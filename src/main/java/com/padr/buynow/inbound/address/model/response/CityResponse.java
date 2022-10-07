package com.padr.buynow.inbound.address.model.response;

import com.padr.buynow.domain.address.entity.City;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResponse {
    
    private final Long id;
    private final String name;

    public static CityResponse of(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
