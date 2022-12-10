package com.padr.buynow.outbound.persistence.user.port;

import java.util.Optional;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface UserPersistencePort extends BaseCacheAndPersistencePort<User> {

    Optional<User> findByIdentityNumber(String identityNumber);

    Optional<User> findByEmail(String email);
}
