package com.dynaop.taskrole.common.entity;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * 系统领域对象的基类，实现了Serializable接口。
 * DomainObject还覆写了hashCode()方法和equals()方法。这两个方法都将基于代理主键进行操作。
 * 只有代理主键相等，领域对象才相等。如果创建的对象的entityId均未赋值，则直接比较物理地址。
 *
 * @author CrayHu(hukl424@163.com)
 * @version Revision: 1.00 Date: 2011-6-13
 */
public class DomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6234793910389347162L;

	/**
	 * 领域对象的代理主键.
	 */
	private String id;

	/*-------------------- construtors --------------------*/

	/**
	 * 默认构造函数。
	 * 
	 */
	public DomainObject() {

	}

	/**
	 * 通过代理主键构造领域对象。
	 * 
	 * @param id
	 */
	public DomainObject(String id) {
		this();
		this.id = id;
	}

	/*----------------- public methods --------------------*/

	/**
	 * 获取领域对象代理主键。
	 *
	 * @return 
	 */
	public String getId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 设置领域对象代理主键。
	 *
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 覆写基类的hashCode方法，如果代理主键不为null，返回Id对应的hashCode值，否则返回基类的hashCode值。
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	/**
	 * 根据代理主键判断领域对象是否相同。
	 * 
	 */
	@Override
	public boolean equals(Object target) {
		if (target == null)
			return false;

		if (target == this)
			return true;

		if (target.getClass() != this.getClass())
			return false;

		DomainObject t = (DomainObject)target;

		//如果领域对象的Id为空，直接判断物理地址
		if (StringUtils.isBlank(id))
			return (t == this);

		return new EqualsBuilder().append(id, t.getId()).isEquals();
	}
}
