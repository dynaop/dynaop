/**
 * 
 */
package com.dynaop.taskrole.main.action;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.action.BaseAction;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-15
 */
@Scope("prototype")
@Controller
public class MainAction extends BaseAction {
	
	
	public String init(){
		return "main";
		
	}
	/**
	 * get top level menu
	 * @return json pattern	id: It is menu's id;text: It is menu's  name;level:It is menu's  level;
	 * child:It is menu's child.These child pattern is json pattern.
	 */
	public void menuTree(){
		int id = 2;
		ArrayList menuList = new ArrayList();
		for(int i=1;i<=id;i++){
			Map<String,Object> menuMap = new HashMap();
			menuMap.put("id", i+"0"+i);
			menuMap.put("level", 1+"");
			menuMap.put("text", "menuName_"+i);
			ArrayList cMenuList = new ArrayList();
			for(int c=1;c<=3;c++){
				Map<String,String> cMenuMap = new HashMap();
				cMenuMap.put("id", i+"1"+c);
				cMenuMap.put("level","2");
				cMenuMap.put("text","childMenu_"+i+"/"+c);
//				just for demo 
				if(i==1){
//					menu 1
					switch(c){
					case 1:cMenuMap.put("url", "http://www.baidu.com");
							break;
					case 2:cMenuMap.put("url", "http://www.sohu.com");
							break;
					case 3:cMenuMap.put("url", "http://www.163.com");
							break;
					}
				}		
				if(i==2){
//					menu 2
					switch(c){
					case 1:cMenuMap.put("url", "http://www.qq.com");
							break;
					case 2:cMenuMap.put("url", "http://www.sina.com.cn");
							break;
					case 3:cMenuMap.put("url", "http://www.taobao.com");
							break;
					}
				}
				cMenuList.add(cMenuMap);
			}
			menuMap.put("child", cMenuList);
			menuList.add(menuMap);
		}
		String menu=JSON.toJSONString(menuList);
		System.out.println("###   "+menu);
		this.sendJson(menu);
	}
}
