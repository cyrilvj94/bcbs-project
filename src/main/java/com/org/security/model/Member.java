package com.org.security.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "member")

public class Member {
	
	@Id
	@SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private Long member_id;
	
	private String name;
	private LocalDate startDate;
	private LocalDate expiryDate;
	private LocalDate dob;
	private String address;
	private Long aadhar;
	private String emailAddress;
	private boolean isPremium;
	
	//Defining relationship. This member takes which policy?
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "Fk_policy_id",
			referencedColumnName = "policyId")
	private Policy policy;
	
	
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
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
	
	public Member() {
		super();
	}
	public Member(Long member_id, String name, LocalDate startDate, LocalDate expiryDate, 
			LocalDate dob, String address, Long aadhar,
			String emailAddress, boolean isPremium) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.dob = dob;
		this.address = address;
		this.aadhar = aadhar;
		this.emailAddress = emailAddress;
		this.isPremium = isPremium;
	}
	
	public Member(String name, LocalDate startDate, LocalDate expiryDate, LocalDate dob,
			String address, Long aadhar,
			String emailAddress, boolean isPremium) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.dob = dob;
		this.address = address;
		this.aadhar = aadhar;
		this.emailAddress = emailAddress;
		this.isPremium = isPremium;
	}
	
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", name=" + name + ", startDate=" + startDate + ", expiryDate="
				+ expiryDate + ", dob=" + dob + ", address=" + address + ", aadhar=" + aadhar + ", emailAddress="
				+ emailAddress + ", isPremium=" + isPremium + "]";
	}

}
