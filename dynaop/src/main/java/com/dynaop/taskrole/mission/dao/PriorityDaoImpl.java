package com.dynaop.taskrole.mission.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.mission.entity.PriorityInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
@Repository("priorityDao")
public class PriorityDaoImpl extends MethodName4StatemenDaoHandler<PriorityInfo> implements PriorityDao {

	public void createPriority(PriorityInfo priorityInfo) {
		this.save(priorityInfo);
	}

	public List<PriorityInfo> getPriList(String userName, int currentPage,
			Page page, int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		List<PriorityInfo> list = this.query(qpbu);
		return list;
	}

	public List<PriorityInfo> getPriListAll() throws Exception {
		return this.query((Object)null);
	}

	public void deletePri(String priID) {
		this.delete(priID);
	}

	public void updatePri(PriorityInfo priInfo) {
		this.update(priInfo);
	}

	public PriorityInfo getPriByID(String priID) {
		return this.getEntity(priID);
	}


	
}
