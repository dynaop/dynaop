/**
 * 
 */
package com.dynaop.taskrole.userinfo.service;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.userinfo.entity.UserBaseInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-29
 */
public interface UserService {
	
	/**
	 * 用户管理 用户列表
	 * @param userName
	 * @param currentPage
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<UserBaseInfo> getUserList(String userName,int currentPage,Page page,int pageSize);
	/**
	 * 通过用户ID获取用户信息
	 * @param loginID
	 * @return
	 */
	public UserBaseInfo getUserInfoByID(String loginID);
	/**
	 * 修改用户
	 * @param UserBaseInfo
	 */
	public void modUser(UserBaseInfo UserBaseInfo);
	/**
	 * 根据登录ID删除用户
	 * @param loginID
	 */
	public void delUser(String loginID);
}
