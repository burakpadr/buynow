package com.padr.buynow.outbound.cache.address.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.address.entity.State;

public interface StateCachePort {

    Optional<State> findById(Long id);

    public List<State> findByCountryId(Long countryId);

    public void saveAll(List<State> states);

    public void deleteAll();
}
