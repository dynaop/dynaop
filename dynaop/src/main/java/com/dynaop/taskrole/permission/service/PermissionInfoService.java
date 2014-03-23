package com.dynaop.taskrole.permission.service;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.permission.entity.PerInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
public interface PermissionInfoService {
	/**
	 * 创建权限
	 * @param perinfo
	 */
	public void createPermission(PerInfo perinfo);
	/**
	 * 获取权限列表
	 * @param userName
	 * @param currentPage
	 * @param page
	 * @param pageSize
	 * @return List<PerInfo>
	 */
	public List<PerInfo> getPerList(String userName, int currentPage, Page page, int pageSize);
	
	/**
	 * 获取所有的权限列表
	 * @return
	 */
	public List<PerInfo> getPerListAll();
	
	/**
	 * 删除权限
	 * @param perID
	 */
	public void delPerInfo(String perID);
	/**
	 * 更新权限基本信息
	 * @param perInfo
	 */
	public void updatePerInfo(PerInfo perInfo);
	/**
	 * 获取单个权限的基本信息
	 * @param perID
	 * @return
	 */
	public PerInfo getPerInfoByID(String perID);
}
