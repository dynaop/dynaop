package com.dynaop.taskrole.mission.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
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
	
	private int currentPage=1;
//	页面显示条数
	private int pageSize=10;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getCreateResult() {
		return createResult;
	}

	public void setCreateResult(String createResult) {
		this.createResult = createResult;
	}
	public MissionInfoService getMissionInfoService() {
		return missionInfoService;
	}

	public void setMissionInfoService(MissionInfoService missionInfoService) {
		this.missionInfoService = missionInfoService;
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
			Page page = new Page(currentPage,pageSize);
			missionList = missionInfoService.getMissionList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
