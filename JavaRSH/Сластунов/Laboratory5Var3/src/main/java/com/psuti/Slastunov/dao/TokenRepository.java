package com.psuti.Slastunov.dao;

import com.psuti.Slastunov.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Optional<Token> findByValue(String value);
    Optional<Token> findTokenByUserId(UUID id);
}

