package com.dynaop.taskrole.menus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.menus.dao.MenuLeftListDao;
import com.dynaop.taskrole.menus.entity.MenuInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
@Service("menusService")
public class MenusServiceImpl implements MenusService {
	@Autowired
	private MenuLeftListDao menuLeftListDao;
/*
 * (non-Javadoc)
 * @see com.dynaop.taskrole.menus.service.MenusService#getLeftMenuList(java.util.Map)
 */
	public List<Map> getLeftMenuList(Map map) {
		ArrayList MenuList = new ArrayList();
		
		List<MenuInfo> topList = menuLeftListDao.getMenusList(null);
		
		for(MenuInfo info:topList){
			Map<String,Object> menuMap = new HashMap();
			menuMap.put("menu_id", info.getMenu_id());
			menuMap.put("menu_name", info.getMenu_name_zh());
			
//			get child menus from dao
			Map<String,String> pmap= new HashMap();
			pmap.put("parent_id", info.getMenu_id());
			List<MenuInfo> childList = menuLeftListDao.getMenusList(pmap);
			
			ArrayList cMenuList = new ArrayList();
			for(MenuInfo cinfo:childList){
				Map<String,Object> cMap = new HashMap();
				cMap.put("menu_id", cinfo.getMenu_id());
				cMap.put("menu_name", cinfo.getMenu_name_zh());
				cMap.put("menu_uri", cinfo.getMenu_uri());
				cMenuList.add(cMap);
			}
			menuMap.put("child", cMenuList);
			MenuList.add(menuMap);
		}
		
		
		return MenuList;
	}

}
