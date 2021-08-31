package com.org.security.service;

import java.util.List;

import com.org.security.model.Resource;
import com.org.security.model.ResourcePerm;
//import com.org.security.model.ResourcePermission;
import com.org.security.model.Role;
import com.org.security.model.RolePermission;

public interface AccessService {

	
	public Resource addResource(Resource resource);
	public Role addRole(Role role);
	
	public RolePermission grantPermissions(RolePermission rolePermission);
	
	public List<RolePermission>  getPermissionsByRoleId(int roleId);
	
	public Role getRoleByRoleID(int roleID);
	
	public Role getByRoleName(String roleName);
	
	public String updatepermissionsByRoleIDAndResourceId( ResourcePerm resourcePerm);
	

	

	
	
	//public String getPermissionsByRoleName(ResourcePerm resourcePerm);
	
	
	
}
