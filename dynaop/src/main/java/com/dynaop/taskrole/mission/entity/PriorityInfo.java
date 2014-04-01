package com.dynaop.taskrole.mission.entity;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
public class PriorityInfo extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String priName;
	private String priDesc;
	private String createTime;
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPriName() {
		return priName;
	}
	public void setPriName(String priName) {
		this.priName = priName;
	}
	public String getPriDesc() {
		return priDesc;
	}
	public void setPriDesc(String priDesc) {
		this.priDesc = priDesc;
	}
	
}
