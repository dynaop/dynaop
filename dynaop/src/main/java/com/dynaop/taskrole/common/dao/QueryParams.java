package com.dynaop.taskrole.common.dao;


public class QueryParams {

	private Page paging;
	private String sortField="createtime";
	private String sortOrder = "DESC";
	/**
	 * @return the paging
	 */
	public Page getPaging() {
		return paging;
	}

	/**
	 * @param paging the paging to set
	 */
	public void setPaging(Page paging) {
		this.paging = paging;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
}
