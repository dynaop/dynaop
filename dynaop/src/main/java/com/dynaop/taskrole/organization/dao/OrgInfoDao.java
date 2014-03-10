package com.dynaop.taskrole.organization.dao;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.organization.entity.OrgInfo;
import com.dynaop.taskrole.role.entity.RoleInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-9
 */
public interface OrgInfoDao {
	/**
	 * 创建新的组织架构到t_org_info中
	 */
	public void createOrgInfo(OrgInfo orgInfo);
	
	/**
	 * 将组织架构与角色进行关联，将关联关系记录到t_rel_org_role中
	 */
	public void saveRelToRole(Map map);
	
	/**
	 * 获取所有的组织机构的机构名与机构ID，无分页
	 */
	public List<OrgInfo> getOrgAll();
	
	/**
	 * 获取组织架构，分页显示
	 * @param userName
	 * @return 
	 */
	public List<OrgInfo> getOrgList(String userName,int currentPage,Page page,int pageSize);
	
	/**
	 * 更新组织机构信息
	 */
	public void updateOrgInfo(OrgInfo org);
	
	/**
	 * 更新机构与角色关系
	 */
	public void updateRelToRole(OrgInfo org);
	
	/**
	 * 删除组织机构，真正物理删除
	 */
	public void deleteOrgInfo(String orgID);
	
	/**
	 * 获取单个组织机构的信息
	 */
	public OrgInfo getOrgByID(String orgID);
}
