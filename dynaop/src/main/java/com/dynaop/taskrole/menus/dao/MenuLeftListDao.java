
package com.dynaop.taskrole.menus.dao;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.menus.entity.MenuInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
public interface MenuLeftListDao {
	/**
	 * get menus list from db
	 * */
	
	public List<MenuInfo> getMenusList(Map map);
	
	/**
	 * 获取菜单的所有列表，不分上下级
	 * @return
	 */
	public List<MenuInfo> getMenusListAll();

}
