package com.dynaop.taskrole.mission.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.common.entity.QueryParamsByUserName;
import com.dynaop.taskrole.mission.entity.MissionInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-23
 */
@Repository("missionInfoDao")
public class MissionInfoDaoImpl extends MethodName4StatemenDaoHandler<MissionInfo> implements MissionInfoDao {

	public void createMissionInfo(MissionInfo missionInfo) {
		this.save(missionInfo);
	}

	public void updateMissionInfo(MissionInfo missionInfo) {
		
	}

	public void saveCurrentMisson(Map map) {
		this.save(map);
	}

	public List<MissionInfo> getMisList(String userName,int currentPage,Page page,int pageSize) {
		QueryParamsByUserName qpbu = new QueryParamsByUserName();
		qpbu.setUserName(userName);
		qpbu.setPaging(page);
		List<MissionInfo> list = this.query(qpbu);
		return list;
	}

	

	
}
