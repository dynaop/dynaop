/**
 * 
 */
package com.dynaop.taskrole.mission.service;

import java.util.HashMap;
import java.util.List;
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
		
		String id = UUID.randomUUID().toString();
		mission.setId(id);
		missionInfoDao.createMissionInfo(mission);
		
		missionMap.put("mission_id", id);
		missionMap.put("curr_state","1");
		missionMap.put("curr_executor", mission.getExecutor());
		missionMap.put("id", UUID.randomUUID().toString());
		missionInfoDao.saveCurrentMisson(missionMap);
		
	}

	public List<MissionInfo> getMissionList(String userName,int currentPage,int pages,int pageSize) throws Exception {
		return missionInfoDao.getMisList( userName, currentPage, pages, pageSize);
	}

}
