package com.dynaop.taskrole.menus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
	public List<Map<String,Object>> getLeftMenuList(Map map) {

		List<MenuInfo> topList = menuLeftListDao.getMenusList(null);

		ArrayList<Map<String,Object>> MenuList = new ArrayList<Map<String,Object>>();
		if(topList==null) return null;
		for(MenuInfo info:topList){
			Map<String,Object> menuMap = new HashMap();
			String menuId = info.getMenu_id();
			menuMap.put("menu_id", menuId);
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

		//		return getMenu(topList);
	}

	private List<Map<String,Object>> getMenu(List<MenuInfo> menuList){
		List<Map<String,Object>> minfoList = new ArrayList<Map<String,Object>>(menuList.size());
		Map<String,Object> menuMap = null;
		List<Map<String,String>> cMenuList = null;
		for(MenuInfo info : menuList){			
			String menuId = info.getMenu_id();
			String menuName = info.getMenu_name_zh();
			String menuUri = info.getMenu_uri();
			String parentId = info.getMenu_id();
			if(StringUtils.isBlank(parentId)){//parent menu
				menuMap = new HashMap<String,Object>();
				menuMap.put("menu_id", menuId);
				menuMap.put("menu_name", menuName);
				cMenuList = new ArrayList<Map<String,String>>();
				menuMap.put("child", cMenuList);
			}else{
				Map<String,String> cMap = new HashMap<String,String>();
				cMap.put("menu_id", menuId);
				cMap.put("menu_name", menuName);
				cMap.put("menu_uri", menuUri);
				if(cMenuList==null){
					cMenuList = new ArrayList<Map<String,String>>();
				}
				cMenuList.add(cMap);
			}

			minfoList.add(menuMap);
		}

		return minfoList;
	}



}
