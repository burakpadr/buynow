package com.padr.buynow.outbound.persistence.user.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.outbound.persistence.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistencePortImpl implements UserPersistencePort {
    
    private final UserRepository userRepository;
    
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
}
