/**
 * 
 */
package com.dynaop.taskrole.common.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.dynaop.taskrole.common.util.LogUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-14
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LogUtils log = LogUtils.getInstance(BaseAction.class);
	protected HttpServletRequest request;

	protected HttpServletResponse response;
	
	protected int currentPage = 1;
	
	protected int pageSize = 10;
	
	protected String sidx;
	
	protected String sord;
	/**
	 * 向前台发送JSON数据
	 * @param jsonStr
	 */
	public void sendJson(String jsonStr){
		try {
			response.setContentType("Application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			log.error("Output content[" + jsonStr + "] failed!", e);
		}
	}
	
	/**
	 * @param servletRequest the servletRequest to set
	 */
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}

	/**
	 * @param servletResponse the servletResponse to set
	 */
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the sidx
	 */
	public String getSidx() {
		return sidx;
	}

	/**
	 * @param sidx the sidx to set
	 */
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	/**
	 * @return the sord
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord the sord to set
	 */
	public void setSord(String sord) {
		this.sord = sord;
	}
}
