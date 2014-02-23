package com.dynaop.taskrole.mission.dao;

import java.util.Map;

import com.dynaop.taskrole.mission.entity.MissionInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-23
 */
public interface MissionInfoDao {
	/**
	 * 创建新的任务到t_mission_info中
	 */
	public void createMissionInfo(MissionInfo missionInfo);
	
	public void updateMissionInfo(MissionInfo missionInfo);
	/**
	 * 将新创建的任务插入到当前任务表t_mission_current中
	 */
	public void saveCurrentMisson(Map map);

}
