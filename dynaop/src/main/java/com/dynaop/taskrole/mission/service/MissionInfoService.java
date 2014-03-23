package com.dynaop.taskrole.mission.service;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
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
	
	/**
	 * 获取当前用户活动任务列表
	 * @param userID
	 * @throws Exception
	 */
	public List<MissionInfo> getMissionList(String userName,int currentPage,Page page,int pageSize) throws Exception ;
	
	
}
