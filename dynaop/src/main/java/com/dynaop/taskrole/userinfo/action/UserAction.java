package com.dynaop.taskrole.userinfo.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.userinfo.entity.UserBaseInfo;
import com.dynaop.taskrole.userinfo.service.UserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
@Scope("prototype")
@Controller
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private UserBaseInfo userInfo ;
	private List<UserBaseInfo> userList;
	Page paging = null;
	private int currentPage=1; 
//	页面显示条数
	private int pageSize=5;
//	总记录数
	private int totalRecord;
//	总页数
	private int totalPages;
	
	private String rid;
	
	
	public String turn2UserList(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		String userName = (String)sessionMap.get(Constants.sessionKey);
		try {
			Page page = new Page(currentPage,pageSize);
			userList = userService.getUserList(userName, currentPage, page, pageSize);
			totalRecord=page.getRecords();
			totalPages=page.getPages();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
//	跳转到用户修改页面
	public String turn2Up(){
//		用于回显用户信息
		userInfo = userService.getUserInfoByID(rid);
		return "success";
	}

	//	修改用户
	public String modUser(){
		userInfo.setLoginId(rid);
		userService.modUser(userInfo);
		turn2UserList();
		return "success";
	}
//	删除用户
	public void delUser(){
		userService.delUser(rid);
	}
	
	public List<UserBaseInfo> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBaseInfo> userList) {
		this.userList = userList;
	}
	public void setUserInfo(UserBaseInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserBaseInfo getUserInfo() {
		return userInfo;
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
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
}
