package com.psuti.Itruhin.dao;

import com.psuti.Itruhin.entity.example.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, String> {
}
