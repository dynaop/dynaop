/**
 * 
 */
package com.dynaop.taskrole.role.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		roleInfoDao.delRolePer(roleId);
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

	public List<Map<String,String>> getRolePerList(String userName, int currentPage,
			Page page, int pageSize) {
		try {
			
			
			return roleInfoDao.getRolePerList(userName, currentPage, page, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, String> getRolePerByID(String roleID) {
		
		try {
			return roleInfoDao.getRolePerByID(roleID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveRolePer(String roleID,Map<String, String> map) {
		
		String perIDS = (String)map.get("perIDS");
		String[] perIDList = perIDS.split(",");
		
		Map<String,String>[] outMap = new HashMap[perIDList.length];  
		
		for(int i = 0;i<outMap.length;i++){
			Map<String,String> map1 = new HashMap();
			map1.put("relID", UUID.randomUUID().toString());
			map1.put("roleID", roleID);
			map1.put("perID", perIDList[i]);
			outMap[i]=map1;
		}
		roleInfoDao.delRolePer(roleID);
		roleInfoDao.insertBatchRolePerRel(outMap);
/*//		获取角色与权限关系表中是否存在当前roleID的关联关系
		boolean flag = false;
		try {
			flag = roleInfoDao.isExistInRelRolePer(roleID);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
//		flag=true时，关系表中存在关系，进行更新操作
		if(flag){
			roleInfoDao.updateRolePerRel(map);
		}else{
//			插入新的关联关系
			roleInfoDao.saveRolePer(map);
		}*/
	}
	
	
	
}
