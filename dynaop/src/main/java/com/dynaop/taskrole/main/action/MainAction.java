/**
 * 
 */
package com.dynaop.taskrole.main.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.action.BaseAction;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-15
 */
@Scope("prototype")
@Controller
public class MainAction extends BaseAction {
	
	
	public String init(){
		return SUCCESS;
		
	}
	
	public void menuTree(){
		String menu = "[{\"id\": 1,\"text\": \"My Documents\",\"children\": [{\"id\": 11,\"text\": \"Photos\",\"state\": \"closed\",\"children\": [{\"id\": 111,\"text\": \"Friend\",\"url\": \"http://www.163.com\"},{\"id\": 112,\"text\": \"Wife\",\"url\": \"http://www.sina.com\"},{\"id\": 113,\"text\": \"Company\",\"url\": \"http://www.baidu.com\"}]},{\"id\": 12,\"text\": \"Program Files\",\"children\": [{\"id\": 121,\"text\": \"Intel\",\"url\": \"http://www.baidu.com\"},{\"id\": 122,\"text\": \"Java\",\"url\": \"http://www.baidu.com\"},{\"id\": 123,\"text\": \"Microsoft Office\",\"url\": \"http://www.baidu.com\"},{\"id\": 124,\"text\": \"Games\",\"url\": \"http://www.baidu.com\"}]},{\"id\": 13,\"text\": \"index.html\",\"url\": \"http://www.baidu.com\"},{\"id\": 14,\"text\": \"about.html\",\"url\": \"http://www.baidu.com\"},{\"id\": 15,\"text\": \"welcome.html\",\"url\": \"http://www.baidu.com\"}]}]";
		this.sendJson(menu);
	}

}
