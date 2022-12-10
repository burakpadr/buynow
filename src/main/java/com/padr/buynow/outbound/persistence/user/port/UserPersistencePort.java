package com.padr.buynow.outbound.persistence.user.port;

import java.util.Optional;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.outbound.persistence.common.BasePersistencePort;

public interface UserPersistencePort extends BasePersistencePort<User> {

    Optional<User> findByIdentityNumber(String identityNumber);

    Optional<User> findByEmail(String email);
}
