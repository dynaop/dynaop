package com.dynaop.taskrole.common.entity;

import com.dynaop.taskrole.common.dao.QueryParams;

public class QueryParamsByUserName extends QueryParams{
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
