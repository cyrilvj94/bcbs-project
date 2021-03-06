package com.org.security.controller;

import java.util.List;

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

import com.org.security.model.Benefits;
import com.org.security.model.Policy;
import com.org.security.model.Resource;
import com.org.security.model.ResourcePerm;
import com.org.security.model.ResourcePermission;
import com.org.security.model.Role;
import com.org.security.model.RolePermission;
import com.org.security.service.AccessService;
import com.org.security.services.BenefitsService;
import com.org.security.services.PolicyService;


@RestController
@RequestMapping("/api/access")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccessController {
	
	@Autowired
	private PolicyService policyService;

	@Autowired
	private AccessService accessService;
	
	@Autowired
	private BenefitsService benefitsService;

	@PostMapping("/addResource")
	// @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	public Resource addResource(@RequestBody Resource resource) {

		return accessService.addResource(resource);
	}

	@PostMapping("/grantPerm")
	// @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	public RolePermission grantPermissions(@RequestBody RolePermission rolePermission) {

		return accessService.grantPermissions(rolePermission);
	}

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {

		return accessService.addRole(role);

	}

	
	
	
	@GetMapping("/getroleByRoleId/{roleID}")
	public Role getRoleByRoleID(@PathVariable int roleID) {

		return accessService.getRoleByRoleID(roleID);
	}

	@GetMapping("/getByRoleName/{roleName}")
	public Role getByRoleName(@PathVariable String roleName) {

		return accessService.getByRoleName(roleName);
	}

	@PostMapping("/createRolewithPerm")
	public String createRoleWithPermissions(@RequestBody ResourcePerm resourcePerm) {

		System.out.println("inside ");
		Role role = new Role();

		role.setRoleName(resourcePerm.getRoleName());

		Role roledata = accessService.addRole(role);

		System.out.println(roledata.getRoleID());
		System.out.println(resourcePerm.getPermissionList());

		for (RolePermission p : resourcePerm.getPermissionList()) {

			p.setRoleId(roledata.getRoleID());
		}

		System.out.println(resourcePerm.getPermissionList());
		for (RolePermission p : resourcePerm.getPermissionList()) {
			accessService.grantPermissions(p);
		}
		return "successFully created";

	}

	@PutMapping("/updatepermissionsByRoleID")
	public String updatepermissionsByRoleIDAndResourceId(@RequestBody ResourcePerm resourcePerm) {

		System.out.println("inside update ");

		return accessService.updatepermissionsByRoleIDAndResourceId(resourcePerm);

	}

	
	  @GetMapping("/getPermissionsByRoleName/{roleName}")
	  public ResourcePerm getPermissionsByRoleName(@PathVariable String roleName){
		  
		  Role role=getByRoleName(roleName);
		  
		  List<RolePermission> rolepermlist=  accessService.getPermissionsByRoleId(role.getRoleID());
		  
		  ResourcePerm resourcePerm=new ResourcePerm();
		  
		  resourcePerm.setRoleName(roleName);
		  resourcePerm.setPermissionList(rolepermlist);
		  
		  
	  return resourcePerm;
	  }
	 
	  

	@GetMapping("/getpermissions/{roleID}")
	public List<RolePermission> getPermissionsByRoleId(@PathVariable int roleID) {

		return accessService.getPermissionsByRoleId(roleID);
	}
	
	@GetMapping("/policy")
	public List<Policy> getAllPolicy() {
		
		return policyService.getAllPlans();
	}
    
	@GetMapping("benefits")
	public List<Benefits> getAllBenefits() {
		return benefitsService.getAllBenefits();
	}
	
	@PostMapping("/benefits")
	public Benefits addNewBenefits(@RequestBody Benefits benefits) {
		return benefitsService.addNewBenefit(benefits);
	}
	
	@DeleteMapping("/benefits/{id}")
	public String deleteBenefits(@PathVariable Long id) {
		 benefitsService.deleteById(id);
		 return "Deleted ";
	}
	
	@PostMapping("/policy")
	public Policy addNewPolicy(@RequestBody Policy policy) {
		return policyService.addNewPolicy(policy);
	}
	
}
