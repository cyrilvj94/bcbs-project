package com.org.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.constants.PermissionURLConstants;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@GetMapping("/viewAll")
	 @PreAuthorize("hasPermission('"+PermissionURLConstants.CUSTOMER_API_SERVICE+"','"+PermissionURLConstants.VIEW+"')")
	public String viewCustomer(){
		return "view Customer" ;
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasPermission('"+PermissionURLConstants.CUSTOMER_API_SERVICE+"','"+PermissionURLConstants.ADD+"')")
	public String createCustomer() {
		return "added Customer"; 
		}
	
	@PutMapping("/edit")
	public void update() {
		System.out.println("updated");
	}
	
	
	@DeleteMapping("/delete")
	public String deleteCustomer() {
		
		return "Customer Deleted" ;
	}
	
	
}
