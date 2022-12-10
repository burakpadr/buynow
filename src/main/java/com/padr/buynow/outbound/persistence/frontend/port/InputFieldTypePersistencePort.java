package com.padr.buynow.outbound.persistence.frontend.port;

import java.util.Optional;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface InputFieldTypePersistencePort extends BaseCacheAndPersistencePort<InputFieldType> {

    Optional<InputFieldType> findByName(String name);
}
