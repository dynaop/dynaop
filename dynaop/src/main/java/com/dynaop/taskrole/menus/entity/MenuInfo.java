package com.dynaop.taskrole.menus.entity;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
public class MenuInfo extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menu_id;
	private String parent_id;
	// English Name
	// private String menu_name;
	private String menu_name_zh;
	private String menu_uri;
	public String getMenu_uri() {
		return menu_uri;
	}
	public void setMenu_uri(String menu_uri) {
		this.menu_uri = menu_uri;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getMenu_name_zh() {
		return menu_name_zh;
	}
	public void setMenu_name_zh(String menu_name_zh) {
		this.menu_name_zh = menu_name_zh;
	}

}
