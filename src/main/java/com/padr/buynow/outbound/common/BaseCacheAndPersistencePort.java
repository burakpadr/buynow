package com.padr.buynow.outbound.common;

import java.util.Optional;

public interface BaseCacheAndPersistencePort<T> {
    
    Optional<T> findById(Long id);

    T save(T t);
}
