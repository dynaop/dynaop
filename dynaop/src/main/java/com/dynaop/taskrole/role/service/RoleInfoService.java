package com.dynaop.taskrole.role.service;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.role.entity.RoleInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
public interface RoleInfoService {
	/**
	 * 创建角色
	 * @param Role
	 * @throws Exception 
	 */
	public void saveRoleInfo(RoleInfo Role) throws Exception;
	
	/**
	 * 获取当前角色列表
	 * @param userName 用户名
	 * 		  pageSize 页面显示条数
	 * @throws Exception
	 */
	public List<RoleInfo> getRoleList(String userName,int currentPage,Page page,int pageSize) throws Exception ;
	
	/**
	 * 获取角色与权限关系，用于角色库列表
	 * @param userName
	 * @param currentPage
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Map<String,String>> getRolePerList(String userName,int currentPage,Page page,int pageSize);
	
	/**
	 * 通过ID获得角色与权限的关系信息
	 * @param roleID
	 * @return
	 */
	public Map<String,String> getRolePerByID(String roleID);
	/**
	 * 更新角色信息
	 * @param RoleInfo
	 */
	public void updateRole(RoleInfo roleInfo);
	
	/**
	 * 删除角色
	 * @param role id
	 */
	public void delRole(String roleId);
	
	/**
	 * 获取角色的所有信息
	 */
	public List<RoleInfo> getRoleAll();
	
	/**
	 * 获取设置的默认角色 ID 
	 */
	public String getDefRoleID();
	
	/**
	 * 更新默认角色设置
	 */
	public void setDefRoleID(String roleID);
	
	/**
	 * 保存角色与权限的关系
	 * @param map
	 */
	public void saveRolePer(String roleID,Map<String,String> map);
}
