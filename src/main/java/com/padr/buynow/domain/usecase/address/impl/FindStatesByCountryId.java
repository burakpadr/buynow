package com.padr.buynow.domain.usecase.address.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.State;
import com.padr.buynow.domain.core.address.service.StateService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindStatesByCountryId implements BaseUseCase<List<State>, Long> {
    
    private final StateService stateService;

    @Override
    public List<State> perform(Long countryId) {
        return stateService.findByCountryId(countryId);
    }
}
