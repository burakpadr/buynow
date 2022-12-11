package com.padr.buynow.domain.usecase.common;

public interface BaseUseCase<T, K> {
    
    T perform(K k);
}
