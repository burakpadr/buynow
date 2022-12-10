package com.padr.buynow.outbound.persistence.frontend.port;

import java.util.Optional;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface InputFieldTypePersistencePort extends BasePersistencePort<InputFieldType> {

    Optional<InputFieldType> findByName(String name);
}
