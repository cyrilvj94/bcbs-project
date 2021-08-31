package com.org.security.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResourcePerm {
	
	private String roleName;
	
	
    List<RolePermission>  permissionList;


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<RolePermission> getPermissionList() {
		return permissionList;
	}


	public void setPermissionList(List<RolePermission> permissionList) {
		this.permissionList = permissionList;
	}


	public ResourcePerm(String roleName, List<RolePermission> permissionList) {
		super();
		this.roleName = roleName;
		this.permissionList = permissionList;
	}


	public ResourcePerm() {
		super();
	}


	
}
