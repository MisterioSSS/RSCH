package com.psuti.Zhalnin.dao;

import com.psuti.Zhalnin.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRolesRepository extends JpaRepository <UserRoles, UUID> {
}
