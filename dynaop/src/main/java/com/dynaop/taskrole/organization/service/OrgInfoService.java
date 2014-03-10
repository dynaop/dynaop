package com.dynaop.taskrole.organization.service;

import java.util.List;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.organization.entity.OrgInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
public interface OrgInfoService {
	/**
	 * 创建组织架构
	 * @param OrgInfo
	 * @throws Exception 
	 */
	public void saveOrgInfo(OrgInfo org) throws Exception;
	
	/**
	 * 获取组织架构列表
	 * @param userID
	 * @throws Exception
	 */
	public List<OrgInfo> getOrgList(String userName,int currentPage,Page page,int pageSize) throws Exception ;
	
	/**
	 * 获取组织架构的所有信息列表
	 */
	public List<OrgInfo> getOrgAll();
	
	/**
	 * 更新组织机构信息
	 */
	public void updateOrgInfo(OrgInfo org);
	
	/**
	 * 删除组织机构，真正物理删除
	 */
	public void deleteOrgInfo(String orgID);

	/**
	 * 获取单个组织机构的信息
	 */
	public OrgInfo getOrgByID(String orgID);
}
