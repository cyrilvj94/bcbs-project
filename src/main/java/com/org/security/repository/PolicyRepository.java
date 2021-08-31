package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.security.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	

}
