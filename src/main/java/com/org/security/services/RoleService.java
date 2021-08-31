package com.org.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.security.model.ResourcePerm;
import com.org.security.model.Role;
import com.org.security.model.RolePermission;
import com.org.security.model.UserRole;
import com.org.security.repository.AccessRepository;
import com.org.security.repository.RolePermissionRepository;
import com.org.security.repository.RoleRepository;
import com.org.security.repository.UserRoleRepository;

//import com.payroll.security.model.Resource;
//import com.payroll.security.model.ResourcePerm;
//import com.payroll.security.model.Role;
//import com.payroll.security.model.RolePermission;
//import com.payroll.security.model.User;
//import com.payroll.security.model.User_Role;
//import com.payroll.security.repository.AccessRepository;
//import com.payroll.security.repository.PermissionRepository;
//import com.payroll.security.repository.RolePermissionRepository;
//import com.payroll.security.repository.RoleRepository;
//import com.payroll.security.repository.UserRepository;
//import com.payroll.security.repository.User_RoleRepository;
//import com.payroll.security.request.PasswordResetRequest;

@Service
public class RoleService {

	@Autowired
	AccessRepository accessRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RolePermissionRepository rolePermissionRepository;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRoleRepository userRoleRepository;


	public RolePermission grantPermissions(RolePermission rolePermission) {

		return rolePermissionRepository.save(rolePermission);

	}


	public Role addRole(Role role) {

		return roleRepository.save(role) ;
	}

	public List<RolePermission> getPermissionsByRoleId(int roleId) {

		return rolePermissionRepository.findByroleId( roleId);
	}


	public Role getRoleByRoleID(int roleID) {

		return roleRepository.findByroleID(roleID);
	}


	public Role getByRoleName(String roleName) {

		return roleRepository.findByroleName(roleName);
	}

	
	public String updatepermissionsByRoleIDAndResourceId(ResourcePerm resourcePerm) {

		Role role=getByRoleName(resourcePerm.getRoleName());

		System.out.println(resourcePerm.getPermissionList());

		for(RolePermission p:resourcePerm.getPermissionList()) {

			p.setRoleId(role.getRoleID());
		}

		System.out.println(resourcePerm);

		for(RolePermission p:resourcePerm.getPermissionList()) {

			RolePermission rp=rolePermissionRepository.findByRoleIdAndResourceId(p.getRoleId(),p.getResourceId());

			rp.setCanView(p.isCanView());
			rp.setCanEdit(p.isCanEdit());
			rp.setCanAdd(p.isCanAdd());
			rp.setCanDelete(p.isCanDelete());
			System.out.println(rp);
			rolePermissionRepository.save(rp);

		}
		return "success";
	}
	


	public String deleteRole(int id) {
		roleRepository.deleteById(id);
		return "Deleted role";
	}

	
	public String setRole(UserRole userRole) {
		userRoleRepository.save(userRole);
		return "Updated";
	}

	
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	
	public String deleteRoleById(int roleId) {
		// TODO Auto-generated method stub
		rolePermissionRepository.deleteById(roleId);
		 
		 return "Deleted Role";
		
	}

}
