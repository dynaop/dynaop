/**
 * 
 */
package com.dynaop.taskrole.role.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.role.dao.RoleInfoDao;
import com.dynaop.taskrole.role.entity.RoleInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
	@Autowired
	private RoleInfoDao roleInfoDao;


	public List<RoleInfo> getRoleList(String userName,int currentPage,Page page,int pageSize) throws Exception {
		return roleInfoDao.getRoleList( userName, currentPage, page, pageSize);
	}

	public void saveRoleInfo(RoleInfo role) throws Exception {
		String id = UUID.randomUUID().toString();
		role.setId(id);
		roleInfoDao.createRoleInfo(role);
	}

	public void updateRole(RoleInfo roleInfo) {
		roleInfoDao.updateRole(roleInfo);
	}

	public void delRole(String roleId) {
		roleInfoDao.delRole(roleId);
	}

	public List<RoleInfo> getRoleAll() {
		return roleInfoDao.getRoleAll();
	}

	public String getDefRoleID() {
		try {
			return roleInfoDao.getDefRoleID();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setDefRoleID(String roleID) {
		roleInfoDao.updateDefRoleID(roleID);
	}
	
}
