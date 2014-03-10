package com.dynaop.taskrole.menus.service;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.user.entity.UserInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
public interface MenusService {
	
	public List<Map<String,Object>> getLeftMenuList(Map map);
}
