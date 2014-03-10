package com.dynaop.taskrole.organization.entity;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
public class OrgInfo extends DomainObject {

	private static final long serialVersionUID = 1L;
	private String orgFname;
	private String orgDesc;
	private String orgParentID;
	private String orgParentName;
	private String roleID;
	private String roleName;
	private String relID;// 角色关系ID

	public String getRelID() {
		return relID;
	}

	public void setRelID(String relID) {
		this.relID = relID;
	}

	public String getOrgParentName() {
		return orgParentName;
	}

	public void setOrgParentName(String orgParentName) {
		this.orgParentName = orgParentName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		if (roleID != null) {
			roleID = roleID.trim();
			if (roleID.endsWith(",")) {
				this.roleID = roleID.substring(0,
						roleID.length() - 1);
			}else{
				this.roleID = roleID;
			}
		}else{
			this.roleID = null;
		}
	}

	public String getOrgParentID() {
		return orgParentID;
	}

	public void setOrgParentID(String orgParentID) {
		if (orgParentID != null) {
			orgParentID = orgParentID.trim();
			System.out.println("***********"+orgParentID.endsWith(","));
			if (orgParentID.endsWith(",")) {
				this.orgParentID = orgParentID.substring(0,
						orgParentID.length() - 1);
			}else{
				this.orgParentID = orgParentID;
			}
		}else{
			this.orgParentID  = null;
		}
	}

	public String getOrgFname() {
		return orgFname;
	}

	public void setOrgFname(String orgFname) {
		this.orgFname = orgFname;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

}
