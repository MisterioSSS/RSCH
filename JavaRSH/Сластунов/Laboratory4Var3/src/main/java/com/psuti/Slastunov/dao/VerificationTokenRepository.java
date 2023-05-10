package com.psuti.Slastunov.dao;

import com.psuti.Slastunov.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {
    Optional<VerificationToken> findVerificationTokenByUserId(UUID id);
}
