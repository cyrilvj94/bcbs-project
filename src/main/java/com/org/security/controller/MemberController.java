package com.org.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.constants.PermissionURLConstants;
import com.org.security.model.Member;
import com.org.security.request.BenefitEnquiryRequestForm;
import com.org.security.request.MemberAddRequestForm;
import com.org.security.services.MemberService;


@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins="*")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	//get all members
	@GetMapping("/viewAll")
	@PreAuthorize("hasPermission('"+PermissionURLConstants.MEMBER_API_SERVICE+"','"+PermissionURLConstants.VIEW+"')")
	public List<Member> viewAllMembers(){
		return memberService.getAllMembers() ;
	}
	
	@PostMapping("/add")
	public Member addMember(@RequestBody Member memberInfo) {
		System.out.println(memberInfo);
		return memberService.addMember(memberInfo);
		
	}
	
	@PutMapping("/edit")
	public void update() { // 100 // 200  // 10
		System.out.println("updated");
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct() {
		
		return "Product Deleted" ;
	}
	
	@PostMapping("/detailsEnquiry")
	public Optional<Member> detailsEnquiry(@RequestBody BenefitEnquiryRequestForm form) {
		Optional<Member> member = memberService.detailsEnquiry(form.getAadhar());
		System.out.println(member);
		return member;
	}
	
	
}
