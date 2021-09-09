package com.org.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.security.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Query("SELECT s FROM Member s WHERE s.aadhar=?1")
	Optional<Member> findMemberByAadhar(Long aadhar);
	
	@Query("SELECT s FROM Member s WHERE s.name=?1")
	Optional<Member> findMemberByName(String name);
	

}
