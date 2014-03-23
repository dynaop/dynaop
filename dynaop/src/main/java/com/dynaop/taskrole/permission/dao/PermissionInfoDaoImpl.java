package com.dynaop.taskrole.permission.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.permission.entity.PerInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
@Repository("perDao")
public class PermissionInfoDaoImpl extends MethodName4StatemenDaoHandler<PerInfo> implements PermissionInfoDao {

	public void savePerInfo(PerInfo perInfo) {
		this.save(perInfo);
	}

	public List<PerInfo> getPerList(String userName, int currentPage,
			Page page, int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		List<PerInfo> list = this.query(qpbu);
		return list;
	}

	public void deletePerInfo(String perID) {
		this.delete(perID);
	}

	public void updatePerInfo(PerInfo perInfo) {
		this.update(perInfo);
	}

	public PerInfo getPerInfoByID(String perID) {
		return this.getEntity(perID);
	}

	public List<PerInfo> getPerListAll() {
		return this.queryEntities(null);
	}

}
