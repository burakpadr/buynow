package com.padr.buynow.domain.core.address.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.State;
import com.padr.buynow.domain.core.address.service.StateService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StateServicePortImpl implements StateServicePort {

    private final StateService stateService;

    @Override 
    public List<State> findByCountryId(Long countryId) {
        return stateService.findByCountryId(countryId);
    }
}
