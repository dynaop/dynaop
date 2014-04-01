/**
 * 
 */
package com.dynaop.taskrole.userinfo.dao;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.userinfo.entity.UserBaseInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-29
 */
public interface UserDao {
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<UserBaseInfo> getUserList(String userName,int currentPage,Page page,int pageSize);
	/**
	 * 更新用户信息
	 * @param userInfo
	 */
	public void updateUser(UserBaseInfo userInfo);
	/**
	 * 通过用户信息表的登录获取用户的基本信息
	 * @param ID
	 * @return
	 */
	public UserBaseInfo getUserByID(String loginID);
	/**
	 * 根据用户登录ID删除用户信息表信息
	 * @param loginID
	 */
	public void delUser(String loginID);
	/**
	 * 根据用户的登录ID删除登录表信息
	 * @param loginID
	 */
	public void delUserLogin(String loginID);
}
