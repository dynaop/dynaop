package com.dynaop.taskrole.permission.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.menus.entity.MenuInfo;
import com.dynaop.taskrole.menus.service.MenusService;
import com.dynaop.taskrole.permission.entity.PerInfo;
import com.dynaop.taskrole.permission.service.PermissionInfoService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
@Scope("prototype")
@Controller
public class PerAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MenusService menusService;
	@Autowired
	private PermissionInfoService perService;
	
	private List<MenuInfo> menuList;
	private List<PerInfo> perList;
	private PerInfo perInfo; 
	private String createResult="";
	
	private int currentPage=1;
//	页面显示条数
	private int pageSize=10;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	private String rid;
	
	
	public List<PerInfo> getPerList() {
		return perList;
	}

	public void setPerList(List<PerInfo> perList) {
		this.perList = perList;
	}
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	public List<MenuInfo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuInfo> menuList) {
		this.menuList = menuList;
	}
	public PerInfo getPerInfo() {
		return perInfo;
	}

	public void setPerInfo(PerInfo perInfo) {
		this.perInfo = perInfo;
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

	public String turn2Per(){
		menuList = menusService.getMenuListAll();
		perInfo = perService.getPerInfoByID(rid);
		return "success";
	}
	/**
	 * 创建权限
	 * @return
	 */
	public String createPer(){
		
		perService.createPermission(perInfo);
		menuList = menusService.getMenuListAll();
		createResult="1";
		return "success";
	}

	public String listPer(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			Page page = new Page(currentPage,pageSize);
			perList = perService.getPerList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public void delPer(){
		perService.delPerInfo(rid);
	}
	
	public String updatePer(){
		perInfo.setId(rid);
		perService.updatePerInfo(perInfo);
		listPer();
		return "success";
	}
	
	
}
