package com.padr.buynow.outbound.countrystatecity.model;

import com.padr.buynow.domain.core.address.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {
    
    private Long id;
    private String name;
    private String iso2;

    public Country to() {
        return Country.builder()
                .id(id)
                .name(name)
                .iso(iso2)
                .build();
    }
}
