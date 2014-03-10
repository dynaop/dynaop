package com.dynaop.taskrole.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.role.entity.RoleInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
@Repository("roleInfoDao")
public class RoleInfoDaoImpl extends MethodName4StatemenDaoHandler<RoleInfo> implements RoleInfoDao {

	public void createRoleInfo(RoleInfo roleInfo) {
		this.save(roleInfo);
	}

	public List<RoleInfo> getRoleList(String userName,int currentPage,Page page,int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		List<RoleInfo> list = this.query(qpbu);
		return list;
	}

	public void updateRole(RoleInfo roleInfo) {
		this.update(roleInfo);
	}

	public void delRole(String roleId) {
		this.update(roleId);
	}

	public List<RoleInfo> getRoleAll() {
		return this.query((Object)null);
	}

	

	
}