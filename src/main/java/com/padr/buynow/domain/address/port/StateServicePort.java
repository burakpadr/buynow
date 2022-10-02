package com.padr.buynow.domain.address.port;

import java.util.List;

import com.padr.buynow.domain.address.entity.State;

public interface StateServicePort {
    
    public List<State> findByCountryId(Long countryId);
}
