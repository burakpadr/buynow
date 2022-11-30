package com.padr.buynow.outbound.redis.address.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.State;
import com.padr.buynow.outbound.redis.address.repository.StateCacheRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StateCachePortImpl implements StateCachePort {

    private final StateCacheRepository stateCacheRepository;

    @Override
    public List<State> findByCountryId(Long countryId) {
        return stateCacheRepository.findByCountryId(countryId);
    }

    @Override
    public void saveAll(List<State> states) {
        stateCacheRepository.saveAll(states);
    }

    @Override
    public void deleteAll() {
        stateCacheRepository.deleteAll();
    }

    @Override
    public Optional<State> findById(Long id) {
        return stateCacheRepository.findById(id);
    }
}
