package com.padr.buynow.outbound.countrystatecity.model;

import com.padr.buynow.domain.address.entity.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityResponse {

    private Long id;
    private String name;

    public City to() {
        return City.builder()
                .id(id)
                .name(name)
                .build();
    }
}
