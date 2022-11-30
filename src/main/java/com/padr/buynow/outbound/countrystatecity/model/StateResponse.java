package com.padr.buynow.outbound.countrystatecity.model;

import com.padr.buynow.domain.core.address.entity.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateResponse {
    
    private Long id;
    private String name;
    private String iso2;

    public State to() {
        return State.builder()
                .id(id)
                .name(name)
                .iso(iso2)
                .build();
    }
}
