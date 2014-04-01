/**
 * 
 */
package com.dynaop.taskrole.mission.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.mission.dao.PriorityDao;
import com.dynaop.taskrole.mission.entity.PriorityInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-30
 */
@Service("priorityService")
public class PriorityServiceImpl implements PriorityService {
	@Autowired
	private PriorityDao priorityDao;

	public void savePriorityInfo(PriorityInfo priInfo) throws Exception {
		String id = UUID.randomUUID().toString();
		priInfo.setId(id);
		priorityDao.createPriority(priInfo);
	}

	public List<PriorityInfo> getPriorityList(String userName, int currentPage,
			Page page, int pageSize) throws Exception {
		return priorityDao.getPriList(userName, currentPage, page, pageSize);
	}

	public List<PriorityInfo> getPriListAll() {
		try {
			return priorityDao.getPriListAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deletePri(String priID) {
		priorityDao.deletePri(priID);
	}

	public void updatePri(PriorityInfo priInfo) {
		priorityDao.updatePri(priInfo);
	}

	public PriorityInfo getPriByID(String priID) {
		return priorityDao.getPriByID(priID);
	}

	

}
