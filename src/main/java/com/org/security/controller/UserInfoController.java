package com.org.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserInfoController {

	
	@GetMapping("/viewAll")
	//@PreAuthorize("hasPermission('hasAccess','READ')")
	public String viewUser(){
		return "view user" ;
	}
	
	@PostMapping("/add")
	public String createUser() {
		return "added user" ;
	}
	
	@DeleteMapping("/delete")
	public String deleteUser() {
		
		return "User Deleted" ;
	}
	
	
}
