package com.org.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benefits")
public class Benefits {
	
	@Id
	private Long benefitId;
	private String benefitName;
	public Long getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
	}
	public String getBenefitName() {
		return benefitName;
	}
	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}
	@Override
	public String toString() {
		return "Benefits [benefitId=" + benefitId + ", benefitName=" + benefitName + "]";
	}
	

	
	

}
