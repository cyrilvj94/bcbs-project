package com.org.security.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {

	


	@Id
	@SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_sequence")
	private Long policyId;
	private String policyName;
	private LocalDate startDate;
	private LocalDate expiryDate;
	private float standardAmount;
	private float premiumAmount;
	private int groupId;
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "policy_benefits_map",
			joinColumns = @JoinColumn(
					name = "policy_id",
					referencedColumnName = "policyId"
					),
			inverseJoinColumns = @JoinColumn(
					name = "benefit_id",
					referencedColumnName = "benefitId")
		
	)
	private List<Benefits> benefits; //Each policy has a list of benfits
	
	public List<Benefits> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public float getStandardAmount() {
		return standardAmount;
	}
	public void setStandardAmount(float standardAmount) {
		this.standardAmount = standardAmount;
	}
	public float getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public Policy() {
		super();
	}
	
	public Policy(Long policyId, String policyName, LocalDate startDate, LocalDate expiryDate, float standardAmount,
			float premiumAmount, String description) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.standardAmount = standardAmount;
		this.premiumAmount = premiumAmount;
		this.description = description;
	}
	
	public Policy(String policyName, LocalDate startDate, LocalDate expiryDate, float standardAmount, float premiumAmount,
			String description) {
		super();
		this.policyName = policyName;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.standardAmount = standardAmount;
		this.premiumAmount = premiumAmount;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", startDate=" + startDate
				+ ", expiryDate=" + expiryDate + ", standardAmount=" + standardAmount + ", premiumAmount="
				+ premiumAmount + ", groupId=" + groupId + ", description=" + description + ", benefits=" + benefits
				+ "]";
	}

	
	
}
