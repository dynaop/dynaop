/**
 * 
 */
package com.dynaop.taskrole.userinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.userinfo.dao.UserDao;
import com.dynaop.taskrole.userinfo.entity.UserBaseInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-29
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<UserBaseInfo> getUserList(String userName,int currentPage,Page page,int pageSize) {

		return userDao.getUserList(userName, currentPage, page, pageSize);
	}

	public UserBaseInfo getUserInfoByID(String loginID) {
		return userDao.getUserByID(loginID);
	}

	public void modUser(UserBaseInfo userInfo) {
		userDao.updateUser(userInfo);
	}

	public void delUser(String loginID) {
		userDao.delUser(loginID);
		userDao.delUserLogin(loginID);
	}
	

}
