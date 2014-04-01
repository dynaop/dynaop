package com.dynaop.taskrole.mission.service;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.mission.entity.PriorityInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
public interface PriorityService {
	/**
	 * 创建任务优先级
	 * @param PriorityInfo
	 * @throws Exception 
	 */
	public void savePriorityInfo(PriorityInfo priInfo) throws Exception;
	
	/**
	 * 分页显示任务优先级列表
	 * @throws Exception
	 */
	public List<PriorityInfo> getPriorityList(String userName,int currentPage,Page page,int pageSize) throws Exception ;
	
	/**
	 * 获取所有任务优先级名称ID
	 * @return List<Map<String,String>>
	 */
	public List<PriorityInfo> getPriListAll();
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
