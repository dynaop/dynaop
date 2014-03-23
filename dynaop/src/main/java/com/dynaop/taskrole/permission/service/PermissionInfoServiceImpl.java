/**
 * 
 */
package com.dynaop.taskrole.permission.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.mission.dao.MissionInfoDao;
import com.dynaop.taskrole.mission.entity.MissionInfo;
import com.dynaop.taskrole.permission.dao.PermissionInfoDao;
import com.dynaop.taskrole.permission.entity.PerInfo;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
@Service("perService")
public class PermissionInfoServiceImpl implements PermissionInfoService {
	@Autowired
	private PermissionInfoDao perDao;

	public void createPermission(PerInfo perinfo) {
		String id = UUID.randomUUID().toString();
		perinfo.setId(id);
		perDao.savePerInfo(perinfo);
	}

	public List<PerInfo> getPerList(String userName, int currentPage,
			Page page, int pageSize) {
		
		return perDao.getPerList(userName, currentPage, page, pageSize);
	}

	public void delPerInfo(String perID) {
		perDao.deletePerInfo(perID);
	}

	public void updatePerInfo(PerInfo perInfo) {
		perDao.updatePerInfo(perInfo);
	}

	public PerInfo getPerInfoByID(String perID) {
		return perDao.getPerInfoByID(perID);
	}

	public List<PerInfo> getPerListAll() {
		return perDao.getPerListAll();
	}



}
