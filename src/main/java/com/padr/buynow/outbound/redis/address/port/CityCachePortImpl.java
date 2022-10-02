package com.padr.buynow.outbound.redis.address.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.entity.City;
import com.padr.buynow.outbound.redis.address.repository.CityCacheRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CityCachePortImpl implements CityCachePort {

    private final CityCacheRepository cityCacheRepository;

    @Override
    public void saveAll(List<City> cities) {
        cityCacheRepository.saveAll(cities);
    }

    @Override
    public void deleteAll() {
        cityCacheRepository.deleteAll();
    }

    @Override
    public List<City> findByStateId(Long stateId) {
        return cityCacheRepository.findByStateId(stateId);
    }
}
