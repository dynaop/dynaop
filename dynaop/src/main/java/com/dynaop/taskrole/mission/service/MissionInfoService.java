package com.dynaop.taskrole.mission.service;

import com.dynaop.taskrole.mission.entity.MissionInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-23
 */
public interface MissionInfoService {
	/**
	 * 创建任务
	 * @param Mission
	 * @throws Exception 
	 */
	public void saveMissionInfo(MissionInfo mission) throws Exception;
	
	
	
	public void updateMissionInfo(MissionInfo mission);

}
