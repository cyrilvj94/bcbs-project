package com.org.security.request;

import java.time.LocalDate;

public class MemberAddRequestForm {
	
	
	private String name;
	private LocalDate startDate;
	private LocalDate expiryDate;
	private LocalDate dob;
	private String address;
	private Long aadhar;
	private String emailAddress;
	private boolean isPremium;
	private Long policyId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAadhar() {
		return aadhar;
	}
	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public MemberAddRequestForm(String name, LocalDate startDate, LocalDate expiryDate, LocalDate dob, String address,
			Long aadhar, String emailAddress, boolean isPremium, Long policyId) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.dob = dob;
		this.address = address;
		this.aadhar = aadhar;
		this.emailAddress = emailAddress;
		this.isPremium = isPremium;
		this.policyId = policyId;
	}
	
	public MemberAddRequestForm() {
		super();
	}
	
	
	
}
