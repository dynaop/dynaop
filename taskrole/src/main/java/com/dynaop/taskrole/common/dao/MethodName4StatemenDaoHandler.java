package com.dynaop.taskrole.common.dao;

import java.util.List;

import com.dynaop.taskrole.common.entity.DomainObject;

/**
 * 该类提供了一种更加简单的DAO编码方式，该类以实体类<code>T</code>的完全限定名 + 每个DAO方法名作为iBatis的statement。
 * 为了方便，ibatis应该开启useStatementNamespaces开关，并将namespace设置为实体类<code>T</code>的完全限定名。<br>
 * 注意：<b>该类的使用限制：只能在直接子类中的最上层方法中使用该类中定义的方法。</b>例如：<br>
 * ibatis配置文件中有&lt;insert id="addUser"&gt;...&lt;/insert&gt;<br>
 * 只能这样用：
 * <pre>
 * public class SubClass extends MethodName4StatemenDaoHandler&lt;User&gt;  {
 *     public void addUser(User u) {
 *         save(u);
 *     }
 * }
 * </pre>
 * 不能这样用：
 * <pre>
 * public class SubClass extends MethodName4StatemenDaoHandler&lt;User&gt;  {
 *     public void addUser(User u) {
 *         ...
 *         doAdd(u);
 *         ...
 *     }
 * 
 *     private void doAddUser(User u) {
 *         save(u);
 *     }
 * }
 * </pre>
 * 因为这样需要ibatis配置文件中有个id为doAddUser的statement与之对应。<br>
 * 如果该限制对你的程序造成不便，那么可以直接继承GenericDaoHandler来进行数据库访问。
 *
 * 
 */
@SuppressWarnings("rawtypes")
public class MethodName4StatemenDaoHandler<T extends DomainObject> extends BaseDaoHandler<T> {
	
	/**
	 * 新增实体类
	 * 
	 * @param entity
	 * @return
	 */
	protected T save(T entity) {
		return save(getQualifiedName(getExecuteMethodName()), entity);
	}
	
	/**
	 * 新增，主要用于新增非<code>DomainObject</code>的对象
	 * 
	 * @param entity
	 */
	protected void save(Object entity) {
		save(getQualifiedName(getExecuteMethodName()), entity);
	}
	
	/**
	 * 修改
	 * 
	 * @param params
	 */
	protected void update(Object params) {
		update(getQualifiedName(getExecuteMethodName()), params);
	}	
	
	/**
	 * 根据参数删除
	 * 
	 * @param params
	 */
	protected void delete(Object params) {
		delete(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 根据参数取得<code>T</code>类型实体
	 * 
	 * @param params
	 * @return
	 */
	protected T getEntity(Object params) {
		return getEntity(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 根据根据参数取得任意类型实体
	 * 
	 * @param param
	 * @return
	 */
	protected Object getObject(Object params) {
		return getObject(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 根据参数查询<code>T</code>类型对象列表，可分页
	 * 
	 * @param params
	 * @return
	 */
	protected List<T> query(QueryParams params) {
		return query(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 根据参数查询任意类型的对象列表，可分页
	 * 
	 * @param params
	 * @return
	 */
	protected List queryEntities(QueryParams params) {
		return queryEntities(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 查询<code>T</code>类型对象列表，不提供分页功能
	 * 
	 * @param params
	 * @return
	 */
	protected List<T> query(Object params) {
		return query(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 查询任意类型的对象列表。不提供分页功能
	 * 
	 * @param params
	 * @return
	 */
	protected List queryEntities(Object params) {
		return queryEntities(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 批量新增/修改/删除。注意批量新增时是无法正确的获取自增主键的值（批处理中最后一个新增可以获取正确的值，其它皆不可以），
	 * 所以如果需要获取自增主键的值，不应该使用该方法。
	 * 
	 * @param statement
	 * @param params
	 * @param batchSize <code>params.length</code>大于该参数的值时，将每batchSize个数据库操作进行一次批处理请求，
	 * 					而不是只进行一次批处理，以免一次性调用导致游标超出最大限制
	 */
	protected void batch(final Object[] params, int batchSize) {
		batch(getQualifiedName(getExecuteMethodName()), params, batchSize);
	}

	/**
	 * 该方法将所有数据库操作作为一次批处理请求。<br>
	 * <b>请注意，如果数据量过大，请调用{@link #batch(String, Object[], int)}，以免一次性调用导致游标超出最大限制。</b>
	 * 
	 * @param statement
	 * @param params
	 * @see #batch(String, Object[], int)
	 */
	protected void batch(final Object[] params) {
		batch(getQualifiedName(getExecuteMethodName()), params);
	}
	
	/**
	 * 根据参数判断该记录是否已存在（逻辑上存在）
	 * 
	 * @param params
	 * @return
	 */
	protected boolean isExistEntity(Object params) {
		return isExistEntity(getQualifiedName(getExecuteMethodName()), params);
	}
	
	public int uniqueIntResult(Object params) {
		return uniqueIntResult(getQualifiedName(getExecuteMethodName()), params);
	}

	/**
	 * 取得当前正在执行的<code>MethodName4StatemenDaoHandler</ccode>子类的方法的名称
	 * 
	 * @return
	 */
	private String getExecuteMethodName() {
		StackTraceElement[] stacks = new Exception().getStackTrace();
        return stacks[2].getMethodName(); 
	}
}
