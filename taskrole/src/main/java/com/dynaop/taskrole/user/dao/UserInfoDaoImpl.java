package com.dynaop.taskrole.user.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.user.entity.UserInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-11
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl extends MethodName4StatemenDaoHandler<UserInfo> implements UserInfoDao {

	public void saveLogin(Map<String, String> param) {
		this.save(param);

	}
	

	public void saveUserInfo(UserInfo userInfo) {
		this.save(userInfo);
	}

	public boolean checkLogin(Map<String, String> param) {		
		return this.isExistEntity(param);
	}

	public void updateUserInfo(UserInfo userInfo) {
		this.update(userInfo);
		
	}

	
}
