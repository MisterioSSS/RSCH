package com.psuti.Mironov.dao;

import com.psuti.Mironov.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {
    Optional<VerificationToken> findVerificationTokenByUserId(UUID id);
}
