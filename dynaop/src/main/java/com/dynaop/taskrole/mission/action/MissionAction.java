package com.dynaop.taskrole.mission.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.mission.entity.MissionInfo;
import com.dynaop.taskrole.mission.service.MissionInfoService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-20
 */
@Scope("prototype")
@Controller
public class MissionAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MissionInfoService missionInfoService;
	private MissionInfo missionInfo;
	private List<MissionInfo> missionList ;
	private String createResult="";
	public String getCreateResult() {
		return createResult;
	}

	public void setCreateResult(String createResult) {
		this.createResult = createResult;
	}
	private int pages=0;
	private int currentPage=1;
	private int pageSize=10;

	public MissionInfoService getMissionInfoService() {
		return missionInfoService;
	}

	public void setMissionInfoService(MissionInfoService missionInfoService) {
		this.missionInfoService = missionInfoService;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<MissionInfo> getMissionList() {
		return missionList;
	}

	public void setMissionList(List<MissionInfo> missionList) {
		this.missionList = missionList;
	}

	public MissionInfo getMissionInfo() {
		return missionInfo;
	}

	public void setMissionInfo(MissionInfo missionInfo) {
		this.missionInfo = missionInfo;
	}

	public String turn2mission(){
		return "success";
	}
	/**
	 * 创建任务
	 * @return
	 */
	public String createMission(){
		try{
			Map<String,Object> sessionMap = ActionContext.getContext().getSession();
			String creator = (String)sessionMap.get(Constants.sessionKey);
			missionInfo.setCreator(creator);
			missionInfoService.saveMissionInfo(missionInfo);
			createResult="success";
			return "success";
		}catch(Exception ex){
			return "error";
		}
	}
	/**
	 * 获取用户活动任务列表，包括创建的和分配的
	 * @return
	 */
	public String listMission(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			missionList = missionInfoService.getMissionList(userName, currentPage, pages, pageSize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
