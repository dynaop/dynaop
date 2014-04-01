/**
 * 
 */
package com.dynaop.taskrole.userinfo.entity;

import com.dynaop.taskrole.common.entity.DomainObject;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-29
 */
public class UserBaseInfo extends DomainObject {
	private String loginId;
	private String username;
	private String pwd;
	private String email;
	private String qq;
	private String deptId;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	

}
