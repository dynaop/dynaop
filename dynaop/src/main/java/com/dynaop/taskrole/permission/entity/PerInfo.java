package com.dynaop.taskrole.permission.entity;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
public class PerInfo extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String perName;
	private String perDesc;
	private String menuIDS;
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public String getPerDesc() {
		return perDesc;
	}
	public void setPerDesc(String perDesc) {
		this.perDesc = perDesc;
	}
	public String getMenuIDS() {
		return menuIDS;
	}
	public void setMenuIDS(String menuIDS) {
		this.menuIDS = menuIDS;
	}
}
