package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.security.model.Resource;
import com.org.security.model.RolePermission;


public interface AccessRepository extends JpaRepository<Resource,Integer> {

	RolePermission save(RolePermission rolePermission);

}
