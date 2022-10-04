package com.padr.buynow.outbound.persistence.user.port;

import java.util.Optional;

import com.padr.buynow.domain.user.entity.User;

public interface UserPersistencePort {

    Optional<User> findById(Long id);

    Optional<User> findByIdentityNumber(String identityNumber);

    Optional<User> findByEmail(String email);

    User save(User user);
}
