package com.org.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.security.model.Benefits;
import com.org.security.repository.BenefitsRepository;


@Service
public class BenefitsService {
	
	@Autowired
	BenefitsRepository benefitsRepository;

	public List<Benefits> getAllBenefits() {
		return benefitsRepository.findAll();
	}

	public Benefits addNewBenefit(Benefits benefits) {
		return benefitsRepository.save(benefits);
	}

	public void deleteById(Long id) {
		 benefitsRepository.deleteById(id);
	}

}
