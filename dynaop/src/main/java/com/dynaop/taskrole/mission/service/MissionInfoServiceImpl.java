/**
 * 
 */
package com.dynaop.taskrole.mission.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.mission.dao.MissionInfoDao;
import com.dynaop.taskrole.mission.entity.MissionInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-23
 */
@Service("missionInfoService")
public class MissionInfoServiceImpl implements MissionInfoService {
	@Autowired
	private MissionInfoDao missionInfoDao;


	public void saveMissionInfo(MissionInfo mission) throws Exception{
		Map<String,String> missionMap = new HashMap<String,String>();		
		missionInfoDao.createMissionInfo(mission);
		
		missionMap.put("mission_id", mission.getId());
		missionMap.put("current_state","1");
		missionMap.put("current_executor", mission.getExecutor());
		missionMap.put("id", UUID.randomUUID().toString());
		missionInfoDao.saveCurrentMisson(missionMap);
		
	}

	public void updateMissionInfo(MissionInfo Mission) {
		// TODO Auto-generated method stub
		
	}

}
