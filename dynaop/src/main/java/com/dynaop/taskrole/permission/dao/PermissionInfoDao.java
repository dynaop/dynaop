package com.dynaop.taskrole.permission.dao;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.permission.entity.PerInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-21
 */
public interface PermissionInfoDao {
	/**
	 * 新建权限
	 * @param perInfo
	 */
	public void savePerInfo(PerInfo perInfo);
	/**
	 * 权限基本信息列表
	 * @param userName
	 * @param currentPage
	 * @param page
	 * @param pageSize
	 * @return List<PerInfo>
	 */
	public List<PerInfo> getPerList(String userName, int currentPage,Page page, int pageSize);
	
	/**
	 * 所有权限基本信息列表
	 * @return
	 */
	public List<PerInfo> getPerListAll();
	
	/**
	 * 删除权限，物理删除
	 * @param perID
	 */
	public void deletePerInfo(String perID);
	/**
	 * 更新权限基本信息
	 * @param perInfo
	 */
	public void updatePerInfo(PerInfo perInfo);
	
	/**
	 * 通过权限ID获取单个权限信息
	 * @param perID
	 * @return
	 */
	public PerInfo getPerInfoByID(String perID);
}
