package com.org.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.security.repository.BenefitsRepository;


@Service
public class BenefitsService {
	
	@Autowired
	BenefitsRepository benefitsRepository;

}
