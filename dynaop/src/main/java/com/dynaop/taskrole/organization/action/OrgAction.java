package com.dynaop.taskrole.organization.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.organization.entity.OrgInfo;
import com.dynaop.taskrole.organization.service.OrgInfoService;
import com.dynaop.taskrole.role.entity.RoleInfo;
import com.dynaop.taskrole.role.service.RoleInfoService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
@Scope("prototype")
@Controller
public class OrgAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OrgInfoService orgInfoService;
	@Autowired
	private RoleInfoService roleInfoService;
	
	private OrgInfo orgInfo;
	private List<OrgInfo> orgList ;
	private List<RoleInfo> roleList ;
	private List<OrgInfo> orgParentList ;
	private String createResult="";
	
	private int currentPage=1;
//	页面显示条数
	private int pageSize=10;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	private String rid;
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public RoleInfoService getRoleInfoService() {
		return roleInfoService;
	}

	public void setRoleInfoService(RoleInfoService roleInfoService) {
		this.roleInfoService = roleInfoService;
	}
	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	public List<OrgInfo> getOrgParentList() {
		return orgParentList;
	}

	public void setOrgParentList(List<OrgInfo> orgParentList) {
		this.orgParentList = orgParentList;
	}
	public OrgInfoService getOrgInfoService() {
		return orgInfoService;
	}

	public void setOrgInfoService(OrgInfoService orgInfoService) {
		this.orgInfoService = orgInfoService;
	}

	public OrgInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	public List<OrgInfo> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<OrgInfo> orgList) {
		this.orgList = orgList;
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

	public String turn2Org(){
		orgParentList = orgInfoService.getOrgAll();
		roleList = roleInfoService.getRoleAll();
		return "success";
	}
	/**
	 * 创建组织架构
	 * @return
	 */
	public String createOrganization(){
		try{
			Map<String,Object> sessionMap = ActionContext.getContext().getSession();
			String creator = (String)sessionMap.get(Constants.sessionKey);
			orgInfoService.saveOrgInfo(orgInfo);
			createResult="success";
			return "success";
		}catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}
	}
	/**
	 * 获取组织架构列表
	 * @return
	 */
	public String listOrg(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			Page page = new Page(currentPage,pageSize);
			orgList = orgInfoService.getOrgList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 更新组织架构
	 * @param OrgInfo
	 */
	public String updateOrg(){
		orgInfoService.updateOrgInfo(orgInfo);
		listOrg();
		return "success";
	}
	
	/**
	 * 删除组织架构
	 * @param org id
	 */
	public void delOrg(){
		orgInfoService.deleteOrgInfo(rid);
	}
	
	
	public void sinOrg(){
		orgInfo = orgInfoService.getOrgByID(rid);
		this.sendJson(JSON.toJSONString(orgInfo));
	}
}
