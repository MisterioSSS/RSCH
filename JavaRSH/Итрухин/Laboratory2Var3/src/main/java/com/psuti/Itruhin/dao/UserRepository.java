package com.psuti.Itruhin.dao;

import com.psuti.Itruhin.entity.example.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
