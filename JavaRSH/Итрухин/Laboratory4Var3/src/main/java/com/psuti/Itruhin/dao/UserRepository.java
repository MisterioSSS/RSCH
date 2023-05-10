package com.psuti.Itruhin.dao;

import com.psuti.Itruhin.entity.example.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
    void removeByEmail(String email);

}
