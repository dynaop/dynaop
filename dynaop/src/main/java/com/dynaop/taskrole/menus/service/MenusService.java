package com.dynaop.taskrole.menus.service;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.menus.entity.MenuInfo;
import com.dynaop.taskrole.user.entity.UserInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
public interface MenusService {
	/**
	 * 获取左侧列表菜单 
	 * @param map
	 * @return  List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getLeftMenuList(Map map);

	/**
	 * 获取菜单列表list 以MenuInfo的list返回
	 * @return
	 */
	public List<MenuInfo> getMenuListAll();
}
