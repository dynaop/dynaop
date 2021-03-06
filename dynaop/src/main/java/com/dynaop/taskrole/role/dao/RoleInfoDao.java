package com.dynaop.taskrole.role.dao;

import java.util.List;
import java.util.Map;

import com.dynaop.taskrole.common.dao.Page;
import com.dynaop.taskrole.role.entity.RoleInfo;


/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-3-5
 */
public interface RoleInfoDao {
	/**
	 * 创建新的角色到t_role_info中
	 */
	public void createRoleInfo(RoleInfo roleInfo);
	
	/**
	 * 获取角色列表
	 * @param userName
	 * @return 
	 */
	public List<RoleInfo> getRoleList(String userName,int currentPage,Page page,int pageSize);
	
	/**
	 * 更新角色信息
	 * @param RoleInfo
	 */
	public void updateRole(RoleInfo roleInfo);
	
	/**
	 * 删除角色,逻辑删除，修改标志位为0
	 * @param role id
	 */
	public void delRole(String roleId);
	/**
	 * 删除角色与权限的关系表
	 * @param roleID
	 */
	public void delRolePer(String roleID);
	
	/**
	 * 通过roleID获取角色与权限的关系信息包括角色的基本信息与权限的基本信息
	 * @param roleID
	 * @return
	 * @throws Exception 
	 */
	public Map<String,String> getRolePerByID(String roleID) throws Exception;
	
	/**
	 * 获取所有有效角色的角色ID与名称
	 */
	public List<RoleInfo> getRoleAll();
	
	/**
	 * 获取默认角色设置 从 t_property表内的default_role项
	 * @throws Exception 
	 */
	public String getDefRoleID() throws Exception;
	/**
	 * 更新默认角色设置
	 */
	public void updateDefRoleID(String roleID);
	
	/**
	 * 创建用户与角色的关联关系
	 */
	public void createRoleUserRel(Map map);
	
	/**
	 * 获取角色与权限关系列表
	 * @throws Exception 
	 */
	public List<Map<String,String>> getRolePerList(String userName,int currentPage,Page page,int pageSize) throws Exception;
	
	/**
	 * 保存角色与权限关系表
	 * @param map
	 */
	public void insertBatchRolePerRel(Map<String,String>[] maps);
}
