/**
 * 
 */
package com.dynaop.taskrole.user.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.user.entity.UserInfo;
import com.dynaop.taskrole.user.service.UserInfoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-14
 */
@Scope("prototype")
@Controller
public class UserLoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserInfoService userInfoService;
	private UserInfo userInfo ;
	private String msg;
	
	public String login(){
		//session中找到用户登录凭证，将不再登录
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		if(StringUtils.isNotBlank((String)sessionMap.get(Constants.sessionKey))){
			return SUCCESS;
		}
		//未登录过的用户需要进行登陆操作
		if(userInfo==null){
			return Action.LOGIN;
		}	
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", userInfo.getUsername());
		param.put("pwd", userInfo.getPwd());
		if(!userInfoService.checkLogin(param)){
			this.setMsg("用户名或者密码错误，请重新登录！");
			return Action.LOGIN;
		}
		sessionMap.put(Constants.sessionKey, userInfo.getUsername());
		return SUCCESS;
	}
	//注册界面初始化
	public String regInit(){
		return SUCCESS;
	}
	//用户注册，跳转到登陆界面
	public String reg(){
		userInfoService.saveUserInfo(userInfo);
		return SUCCESS;
	}
	
/*	public void checkRegUser(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", userInfo.getUsername());
		boolean hasUser = userInfoService.checkLogin(param);
		this.sendJson(String.valueOf(hasUser));
	}*/
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
