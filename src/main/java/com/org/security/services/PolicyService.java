package com.org.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.security.model.Policy;
import com.org.security.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	 PolicyRepository policyRepo;
	
	public List<Policy> getAllPlans() {
		
		return policyRepo.findAll();
	}

	public Policy addNewPolicy(Policy policy) {
		return policyRepo.save(policy);
	}

}
