package com.dynaop.taskrole.userinfo.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.userinfo.entity.UserBaseInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-29
 */
@Repository("userDao")
public class UserDaoImpl extends MethodName4StatemenDaoHandler<UserBaseInfo> implements UserDao {

	public List<UserBaseInfo> getUserList(String userName,int currentPage,Page page,int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		return this.queryEntities(qpbu);
	}


	public void updateUser(UserBaseInfo userInfo) {
		this.update(userInfo);
	}


	public UserBaseInfo getUserByID(String loginID) {
		return this.getEntity(loginID);
	}


	public void delUser(String loginID) {
		this.delete(loginID);
	}


	public void delUserLogin(String loginID) {
		this.delete(loginID);
	}

	
}
