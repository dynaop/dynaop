package com.dynaop.taskrole.mission.dao;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.mission.entity.MissionInfo;
import com.dynaop.taskrole.mission.entity.PriorityInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
public interface PriorityDao {
	/**
	 * 创建新的任务优先级到t_miss_priority中
	 */
	public void createPriority(PriorityInfo priorityInfo);
	
	/**
	 * 分页显示 任务优先级
	 * @return 
	 */
	public List<PriorityInfo> getPriList(String userName,int currentPage,Page page,int pageSize);
	
	/**
	 * 获取所有的任务优先级
	 * @return
	 * @throws Exception 
	 */
	public List<PriorityInfo> getPriListAll() throws Exception;
	/**
	 * 删除任务优先级 by id
	 * @param priID
	 */
	public void deletePri(String priID);
	/**
	 * 更新任务优先级，自动更新创建时间
	 * @param priInfo
	 */
	public void updatePri(PriorityInfo priInfo);
	/**
	 * 通过优先级ID获取优先级信息
	 * @param priID
	 * @return
	 */
	public PriorityInfo getPriByID(String priID);
}
