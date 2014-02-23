package com.dynaop.taskrole.mission.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dynaop.taskrole.common.action.BaseAction;
import com.dynaop.taskrole.mission.entity.MissionInfo;
import com.dynaop.taskrole.mission.service.MissionInfoService;

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
	
	
	public MissionInfo getMissionInfo() {
		return missionInfo;
	}

	public void setMissionInfo(MissionInfo missionInfo) {
		this.missionInfo = missionInfo;
	}

	public String turn2mission(){
		return "success";
	}

	public String createMission(){
		try{
			
			missionInfoService.saveMissionInfo(missionInfo);
		}catch(Exception ex){
			return "error";
		}
		return "success";
	}
}
