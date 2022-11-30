package com.padr.buynow.outbound.redis.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.address.entity.State;

@Repository
public interface StateCacheRepository extends CrudRepository<State, Long> {

    List<State> findByCountryId(Long countryId);
}
