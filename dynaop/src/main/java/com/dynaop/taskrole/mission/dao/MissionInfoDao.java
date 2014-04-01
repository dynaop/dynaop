package com.dynaop.taskrole.mission.dao;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
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
	
	/**
	 * 将新创建的任务插入到当前任务表t_mission_current中
	 */
	public void saveCurrentMisson(Map map);
	
	/**
	 * 通过用户名获取用户当前活动的任务，包括创建和分配的,分页显示
	 * @param userName
	 * @return 
	 */
	public List<MissionInfo> getMisList(String userName,int currentPage,Page page,int pageSize);
	
	/**
	 * 获取所有的有效的任务列表
	 * @return
	 * @throws Exception 
	 */
	public List<MissionInfo> getMissListAll() throws Exception;
}
