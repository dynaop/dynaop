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

}
