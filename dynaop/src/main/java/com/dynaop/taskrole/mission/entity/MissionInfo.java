package com.dynaop.taskrole.mission.entity;

import java.util.Date;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-23
 */
public class MissionInfo extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String missionName;
	private String descr;
	private String planTime;
	private String timeUnit;
	private Date startTime;
	private Date endTime;
	private String missPriority;
	private String creator;
	private String executor;
	private String misParent;
	
	public String getMisParent() {
		return misParent;
	}
	public void setMisParent(String misParent) {
		this.misParent = misParent;
	}
	
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMissPriority() {
		return missPriority;
	}
	public void setMissPriority(String missPriority) {
		this.missPriority = missPriority;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
