package com.padr.buynow.outbound.persistence.common;

import java.util.Optional;

public interface BasePersistencePort<T> {
    
    Optional<T> findById(Long id);

    T save(T t);
}
