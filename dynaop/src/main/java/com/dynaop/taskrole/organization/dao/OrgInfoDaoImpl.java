package com.dynaop.taskrole.organization.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.organization.entity.OrgInfo;
import com.dynaop.taskrole.role.entity.RoleInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
@Repository("orgInfoDao")
public class OrgInfoDaoImpl extends MethodName4StatemenDaoHandler<OrgInfo> implements OrgInfoDao {

	public void createOrgInfo(OrgInfo orgInfo) {
		this.save(orgInfo);
	}

	public void saveRelToRole(Map map) {
		this.save(map);
	}

	public List<OrgInfo> getOrgList(String userName, int currentPage,Page page, int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		List<OrgInfo> list = this.query(qpbu);
		return list;
	}

	public List<OrgInfo> getOrgAll() {
		return this.query((Object)null);
	}

	public void updateOrgInfo(OrgInfo org) {
		this.update(org);
	}

	public void deleteOrgInfo(String orgID) {
		this.delete(orgID);
	}

	public void updateRelToRole(OrgInfo org) {
		this.update(org);
	}

	public OrgInfo getOrgByID(String orgID) {
		return this.getEntity(orgID);
	}

	
}
