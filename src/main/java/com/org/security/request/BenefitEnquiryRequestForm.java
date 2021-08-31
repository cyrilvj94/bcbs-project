package com.org.security.request;

public class BenefitEnquiryRequestForm {
	

	private Long aadhar;

	public Long getAadhar() {
		return aadhar;
	}
	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}
	
	public BenefitEnquiryRequestForm(Long aadhar) {
		super();
		this.aadhar = aadhar;
	
	}
	@Override
	public String toString() {
		return "BenefitEnquiryRequestForm [aadhar=" + aadhar  + "]";
	}
	
	public BenefitEnquiryRequestForm() {
		super();
	}

}
