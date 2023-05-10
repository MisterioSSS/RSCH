package com.psuti.Mironov.dao;

import com.psuti.Mironov.entity.example.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
