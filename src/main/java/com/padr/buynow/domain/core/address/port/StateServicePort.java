package com.padr.buynow.domain.core.address.port;

import java.util.List;

import com.padr.buynow.domain.core.address.entity.State;

public interface StateServicePort {
    
    public List<State> findByCountryId(Long countryId);
}
