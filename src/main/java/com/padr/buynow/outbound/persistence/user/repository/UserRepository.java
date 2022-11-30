package com.padr.buynow.outbound.persistence.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByIdentityNumber(String identityNumber);

    Optional<User> findByEmail(String email);
}
