package com.dynaop.taskrole.mission.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.mission.entity.PriorityInfo;
import com.dynaop.taskrole.mission.service.PriorityService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
@Scope("prototype")
@Controller
public class PriorityAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PriorityService priorityService;
	
	private PriorityInfo priInfo;
	private List<PriorityInfo> priList;
	private String createResult="";
	private int currentPage=1;
	private String rid;
//	页面显示条数
	private int pageSize=10;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	
	public String turn2Priority(){
		return "success";
	}
	
	/**
	 * 创建任务优先级
	 * @return
	 */
	public String createPriority(){
		try{
			priorityService.savePriorityInfo(priInfo);
			createResult="1";
			return "success";
		}catch(Exception ex){
			return "error";
		}
	}
	/**
	 * 获取任务优先级列表，分页显示
	 * @return
	 */
	public String listPriority(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			Page page = new Page(currentPage,pageSize);
			priList = priorityService.getPriorityList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 删除任务优先级
	 */
	public void delPriority(){
		priorityService.deletePri(rid);
	}
	/**
	 * 修改任务优先级
	 * @return
	 */
	public String modPriority(){
		priInfo.setId(rid);
		priorityService.updatePri(priInfo);
		listPriority();
		return "success";
	}
	/**
	 * 跳转到更新优先级页面，并回显对应信息
	 * @return
	 */
	public String turn2ModPri(){
		priInfo = priorityService.getPriByID(rid);
		return "success";
	}
	
	public List<PriorityInfo> getPriList() {
		return priList;
	}
	public void setPriList(List<PriorityInfo> priList) {
		this.priList = priList;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

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
	public PriorityService getPriorityService() {
		return priorityService;
	}
	public void setPriorityService(PriorityService priorityService) {
		this.priorityService = priorityService;
	}
	public PriorityInfo getPriInfo() {
		return priInfo;
	}
	public void setPriInfo(PriorityInfo priInfo) {
		this.priInfo = priInfo;
	}

	public String getCreateResult() {
		return createResult;
	}

	public void setCreateResult(String createResult) {
		this.createResult = createResult;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	
	
}
