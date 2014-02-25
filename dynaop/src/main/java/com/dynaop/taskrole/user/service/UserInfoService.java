/**
 * 
 */
package com.dynaop.taskrole.user.service;

import java.util.Map;

import com.dynaop.taskrole.user.entity.UserInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-11
 */
public interface UserInfoService {
	
	public void saveUserInfo(UserInfo user);
	
	public boolean checkLogin(Map<String,String> param);
	
	public void updateUserInfo(UserInfo user);

}
