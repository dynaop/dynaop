package com.dynaop.taskrole.main.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.menus.service.MenusService;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-15
 */
@Scope("prototype")
@Controller
public class MainAction extends BaseAction {
	
	@Autowired
	private MenusService menusService;
	
	
	public String init(){
		return "main";
		
	}
	/**
	 * get top level menu
	 * @return json pattern	id: It is menu's id;text: It is menu's  name;level:It is menu's  level;
	 * child:It is menu's child.These child pattern is json pattern.
	 */
	public void menuTree(){
		List<Map> menuList = menusService.getLeftMenuList(null);
		String menu=JSON.toJSONString(menuList);
		System.out.println("###   "+menu);
		this.sendJson(menu);
	}
}
