package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.security.model.UserRole;

@Repository
public interface  UserRoleRepository  extends JpaRepository<UserRole, String>{

	
}
