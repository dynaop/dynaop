package com.dynaop.taskrole.main.action;

import java.io.UnsupportedEncodingException;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		List<Map<String,Object>> menuList=null;
		menuList = menuList = menusService.getLeftMenuList(null);
		String menu=null;
		if(menuList==null){
			/*menu = "[{\"child\":[{\"menu_id\":\"01001\",\"menu_name\":\"任务列表\",\"menu_uri\":\"/mission/misList.action\"},{\"menu_id\":\"01002\",\"menu_name\":\"创建任务\",\"menu_uri\":\"/mission/turn2mission.action\"},{\"menu_id\":\"01003\",\"menu_name\":\"任务模板\",\"menu_uri\":\"http://www.baidu.com\"}],\"menu_id\":\"01000\",\"menu_name\":\"任务管理\"},{\"child\":[{\"menu_id\":\"02001\",\"menu_name\":\"当前团队列表\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"02002\",\"menu_name\":\"所有团队列表\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"02003\",\"menu_name\":\"团队管理\",\"menu_uri\":\"http://www.baidu.com\"}],\"menu_id\":\"02000\",\"menu_name\":\"团队管理\"},{\"child\":[{\"menu_id\":\"03001\",\"menu_name\":\"用户信息\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"03002\",\"menu_name\":\"通用设置\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"03003\",\"menu_name\":\"任务设置\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"03004\",\"menu_name\":\"角色设置\",\"menu_uri\":\"http://www.baidu.com\"},{\"menu_id\":\"03005\",\"menu_name\":\"团队设置\",\"menu_uri\":\"http://www.baidu.com\"}],\"menu_id\":\"03000\",\"menu_name\":\"用户设置\"}]";
			try {
				menu = new String(menu.getBytes("GBK"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				
			}*/
			menuList = menusService.getLeftMenuList(null);
		}else{			
			menu = JSON.toJSONString(menuList);
		}
		this.sendJson(menu);
	}
}
