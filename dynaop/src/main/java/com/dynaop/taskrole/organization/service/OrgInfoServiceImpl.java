/**
 * 
 */
package com.dynaop.taskrole.organization.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.organization.dao.OrgInfoDao;
import com.dynaop.taskrole.organization.entity.OrgInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
@Service("orgInfoService")
public class OrgInfoServiceImpl implements OrgInfoService {
	@Autowired
	private OrgInfoDao orgInfoDao;


	public void saveOrgInfo(OrgInfo org) throws Exception {
		String id = UUID.randomUUID().toString();
		org.setId(id);
//		插入org基本信息
		orgInfoDao.createOrgInfo(org);
//		插入与角色关系
		if(org.getRoleID() != null && org.getRoleID()!=","){
			String roleID = org.getRoleID();
			Map<String,String> relMap = new HashMap<String,String>();
			String relID = UUID.randomUUID().toString();
			relMap.put("relID", relID);
			relMap.put("orgID", org.getId());
			relMap.put("roleID", roleID);
			orgInfoDao.saveRelToRole(relMap);
		}
	}

	public List<OrgInfo> getOrgList(String userName, int currentPage, Page page, int pageSize) throws Exception {
		return orgInfoDao.getOrgList(userName, currentPage, page, pageSize);
	}

	public List<OrgInfo> getOrgAll() {
		return orgInfoDao.getOrgAll();
	}

	public void updateOrgInfo(OrgInfo org) {
		orgInfoDao.updateOrgInfo(org);
		orgInfoDao.updateRelToRole(org);
	}

	public void deleteOrgInfo(String orgID) {
		orgInfoDao.deleteOrgInfo(orgID);
	}

	public OrgInfo getOrgByID(String orgID) {
		return orgInfoDao.getOrgByID(orgID);
	}

}
