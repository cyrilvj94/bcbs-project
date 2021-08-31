package com.org.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.security.model.Role;
import com.org.security.model.RolePermission;

public interface RoleRepository extends JpaRepository<Role,Integer>{

	public Role findByroleID(int roleId);


	 public Role findByroleName(String roleName);


}
