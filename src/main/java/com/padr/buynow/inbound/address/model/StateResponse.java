package com.padr.buynow.inbound.address.model;

import com.padr.buynow.domain.address.entity.State;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateResponse {

    private Long id;
    private String name;
    private String iso;

    public static StateResponse of(State state) {
        return StateResponse.builder()
                .id(state.getId())
                .name(state.getName())
                .iso(state.getIso())
                .build();
    }
}
