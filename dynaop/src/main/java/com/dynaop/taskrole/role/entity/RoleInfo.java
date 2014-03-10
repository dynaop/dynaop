package com.dynaop.taskrole.role.entity;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
public class RoleInfo extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleName;
	private String roleDesc;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
