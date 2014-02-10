/**
 * 
 */
package com.dynaop.taskrole.user.dao;

import java.util.Map;

import com.dynaop.taskrole.user.entity.UserInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-11
 */
public interface UserInfoDao {
	//save user login info
	public void saveLogin(Map<String,String> param);
	//save user info
	public void saveUserInfo(UserInfo userInfo);
	//check user login
	public boolean checkLogin(Map<String,String> param);
	
	public void updateUserInfo(UserInfo userInfo);

}
