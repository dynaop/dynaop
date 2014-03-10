package com.dynaop.taskrole.role.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.role.entity.RoleInfo;
import com.dynaop.taskrole.role.service.RoleInfoService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
@Scope("prototype")
@Controller
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RoleInfoService roleInfoService;
	private List<RoleInfo> roleList;
	private String createResult="";
	private RoleInfo roleInfo;
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	Page paging = null;
	private int currentPage=1; 
//	页面显示条数
	private int pageSize=5;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	private String rid;
	

	public void setRid(String rid) {
		this.rid = rid;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
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

	public String getCreateResult() {
		return createResult;
	}

	public void setCreateResult(String createResult) {
		this.createResult = createResult;
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
	/**
	 * 跳转到创建角色页面
	 * @return
	 */
	public String turn2Role(){
		return "success";
	}
	/**
	 * 创建任务
	 * @return
	 */
	public String createRole(){
		try{
			Map<String,Object> sessionMap = ActionContext.getContext().getSession();
			String creator = (String)sessionMap.get(Constants.sessionKey);
			roleInfoService.saveRoleInfo(roleInfo);
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
	public String listRole(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			Page page = new Page(currentPage,pageSize);
			roleList = roleInfoService.getRoleList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 更新角色信息
	 * @param RoleInfo
	 */
	public String updateRole(){
		roleInfoService.updateRole(roleInfo);
		listRole();
		return "success";
	}
	
	/**
	 * 删除角色
	 * @param role id
	 */
	public void delRole(){
		roleInfoService.delRole(rid);
	}
}
