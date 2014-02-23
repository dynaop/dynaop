package com.dynaop.taskrole.mission.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
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

	

	
}
