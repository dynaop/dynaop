/**
 * 
 */
package com.dynaop.taskrole.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.role.dao.RoleInfoDao;
import com.dynaop.taskrole.user.dao.UserInfoDao;
import com.dynaop.taskrole.user.entity.UserInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-11
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private RoleInfoDao roleInfoDao;
	/* (non-Javadoc)
	 * @see com.dynaop.taskrole.user.service.UserInfoService#saveUserInfo(com.dynaop.taskrole.user.entity.UserInfo)
	 */
	public void saveUserInfo(UserInfo userInfo) {
		Map<String,String> loginMap = new HashMap<String,String>();
		String loginId =  UUID.randomUUID().toString();
		loginMap.put("id", loginId);
		loginMap.put("username", userInfo.getUsername());
		loginMap.put("password", userInfo.getPwd());
		
		userInfoDao.saveLogin(loginMap);
		userInfo.setLoginId(loginId);
		String userID = UUID.randomUUID().toString();
		userInfo.setId(userID);
		userInfoDao.saveUserInfo(userInfo);
		
//		加入用户角色的默认关系
//		获取默认角色ID
		try {
			String relID = UUID.randomUUID().toString();
			String roleID =  roleInfoDao.getDefRoleID();
			Map<String,String> relMap = new HashMap<String,String>();
			relMap.put("id", relID);
			relMap.put("userID", userID);
			relMap.put("roleID",roleID);
			roleInfoDao.createRoleUserRel(relMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.dynaop.taskrole.user.service.UserInfoService#checkLogin(java.util.Map)
	 */
	public boolean checkLogin(Map<String, String> param) {
		return userInfoDao.checkLogin(param);
	}

	/* (non-Javadoc)
	 * @see com.dynaop.taskrole.user.service.UserInfoService#updateUserInfo(com.dynaop.taskrole.user.entity.UserInfo)
	 */
	public void updateUserInfo(UserInfo userInfo) {
		userInfoDao.updateUserInfo(userInfo);

	}

}
