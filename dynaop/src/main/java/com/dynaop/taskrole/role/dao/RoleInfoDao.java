package com.dynaop.taskrole.role.dao;

import java.util.List;

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
	 * 获取所有有效角色的角色ID与名称
	 */
	public List<RoleInfo> getRoleAll();
	
}
