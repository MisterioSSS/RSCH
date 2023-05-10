package com.psuti.Slastunov.dao;

import com.psuti.Slastunov.entity.example.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, String> {
}
