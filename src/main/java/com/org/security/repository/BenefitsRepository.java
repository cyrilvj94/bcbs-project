package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.security.model.Benefits;


@Repository
public interface BenefitsRepository extends JpaRepository<Benefits, Long>{

}
