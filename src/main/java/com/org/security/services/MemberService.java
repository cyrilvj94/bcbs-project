package com.org.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.security.model.Member;
import com.org.security.request.BenefitEnquiryRequestForm;
import com.org.security.request.MemberAddRequestForm;

@Service
public class MemberService {
	
	@Autowired
	com.org.security.repository.MemberRepository memberRepository;
	
	public Optional<Member> getMemberDetails(BenefitEnquiryRequestForm requestForm) {
		return memberRepository.findMemberByAadhar(requestForm.getAadhar());
		}
	
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}

	public Member addMember(Member memberInfo) {
		return memberRepository.save(memberInfo);
	}
	
	
	public Optional<Member> detailsEnquiry(Long aadhar) {
		return memberRepository.findMemberByAadhar(aadhar);
	}
	
	
	

}
