package com.org.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.model.ResourcePerm;
import com.org.security.model.Role;
import com.org.security.model.RolePermission;
import com.org.security.model.UserRole;
import com.org.security.services.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@PostMapping("/grantPerm")
	public RolePermission grantPermissions(@RequestBody RolePermission rolePermission) {
		return roleService.grantPermissions(rolePermission);
	}
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
	@PostMapping("/setRole")
	public String setRole(@RequestBody UserRole userRole) {
		return roleService.setRole(userRole);
	}
	
	@DeleteMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable int id) {
		return roleService.deleteRole(id);
	}
	
	@GetMapping("/getroleByRoleId/{roleId}")
	public Role getRoleByRoleID(@PathVariable int roleId) {
		return roleService.getRoleByRoleID(roleId);
	}
	
	@GetMapping("/getByRoleName/{roleName}")
	public Role getByRoleName(@PathVariable String roleName) {
		return roleService.getByRoleName(roleName);
	}
	
	@PostMapping("/createRolewithPerm")
	public String createRoleWithPermissions(@RequestBody ResourcePerm resourcePerm) {


		Role role = new Role();

		role.setRoleName(resourcePerm.getRoleName());

		Role roledata = roleService.addRole(role);

		System.out.println(roledata.getRoleID());
		System.out.print(resourcePerm.getPermissionList());

		for (RolePermission p : resourcePerm.getPermissionList()) {

			p.setRoleId(roledata.getRoleID());
		}

		System.out.println(resourcePerm.getPermissionList());
		for (RolePermission p : resourcePerm.getPermissionList()) {
			roleService.grantPermissions(p);
		}
		return "successFully created";

	}

	@PutMapping("/updatepermissionsByRoleID")
	public String updatepermissionsByRoleIDAndResourceId(@RequestBody ResourcePerm resourcePerm) {


		return roleService.updatepermissionsByRoleIDAndResourceId(resourcePerm);

	}

	
	  @GetMapping("/getPermissionsByRoleName/{roleName}")
	  public ResourcePerm getPermissionsByRoleName(@PathVariable String roleName){
		  
		  Role role=getByRoleName(roleName);
		  
		  List<RolePermission> rolepermlist=  roleService.getPermissionsByRoleId(role.getRoleID());
		  
		  ResourcePerm resourcePerm=new ResourcePerm();
		  
		  resourcePerm.setRoleName(roleName);
		  resourcePerm.setPermissionList(rolepermlist);
		  
		  
	  return resourcePerm;
	  }
	 
	  

	@GetMapping("/getpermissions/{roleID}")
	public List<RolePermission> getPermissionsByRoleId(@PathVariable int roleID) {

		return roleService.getPermissionsByRoleId(roleID);
	}
	
	
	@GetMapping("/viewAllRoles")
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}


    
	@DeleteMapping("/delete/{id}")
	 public String deleteRoleById(@PathVariable Integer id) {
		System.out.println("delete " + id);
		return roleService.deleteRole(id);
	}
	
	

}
