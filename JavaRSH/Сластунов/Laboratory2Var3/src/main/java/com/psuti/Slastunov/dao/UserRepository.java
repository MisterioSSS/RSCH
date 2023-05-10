package com.psuti.Slastunov.dao;

import com.psuti.Slastunov.entity.example.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
