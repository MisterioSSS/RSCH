package com.psuti.Zhalnin.dao;


import com.psuti.Zhalnin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository <Role, String> {

}
