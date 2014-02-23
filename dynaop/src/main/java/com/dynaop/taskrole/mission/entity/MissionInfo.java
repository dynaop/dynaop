package com.dynaop.taskrole.mission.entity;

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
	private String mission_name;
	private String desc;
	private String plan_time;
	private String time_unit;
	private String start_time;
	private String end_time;
	private String mission_level;
	private String creator;
	
	private String executor;
	
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getMission_name() {
		return mission_name;
	}
	public void setMission_name(String mission_name) {
		this.mission_name = mission_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPlan_time() {
		return plan_time;
	}
	public void setPlan_time(String plan_time) {
		this.plan_time = plan_time;
	}
	public String getTime_unit() {
		return time_unit;
	}
	public void setTime_unit(String time_unit) {
		this.time_unit = time_unit;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getMission_level() {
		return mission_level;
	}
	public void setMission_level(String mission_level) {
		this.mission_level = mission_level;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
