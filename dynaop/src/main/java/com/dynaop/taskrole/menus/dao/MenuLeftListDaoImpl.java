package com.dynaop.taskrole.menus.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dynaop.taskrole.common.dao.MethodName4StatemenDaoHandler;
import com.dynaop.taskrole.menus.entity.MenuInfo;
import com.dynaop.taskrole.user.entity.UserInfo;
/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-2-19
 */
@Repository("menuLeftListDao")
public class MenuLeftListDaoImpl extends MethodName4StatemenDaoHandler<MenuInfo> implements MenuLeftListDao {

	public List<MenuInfo> getMenusList(Map map) {
		return this.query(map);
	}


	
}
