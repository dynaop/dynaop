/**
 * 
 */
package com.dynaop.taskrole.common.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import com.dynaop.taskrole.common.entity.DomainObject;
import com.dynaop.taskrole.common.util.EmptyObject;
import com.dynaop.taskrole.common.util.LogUtils;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.BatchException;
/**
 * @author huangjianghua
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class BaseDaoHandler<T extends DomainObject> {

	/**
	 * log4j记录日志
	 */
	LogUtils logger = LogUtils.getInstance(BaseDaoHandler.class);
	/**
	 * 分页statement后缀：_count
	 */
	protected static final String COUNT_STATEMENT_SUFFIX = "_count";

	private String entityClass;

	/**
	 * 用于写操作的Template
	 */
	private SqlMapClient writeSqlMapClient;

	/**
	 * 用于读操作的Template
	 */
	private SqlMapClient readSqlMapClient;

	/**
	 * @return the writeSqlMapClient
	 */
	public SqlMapClient getwriteSqlMapClient() {
		return writeSqlMapClient;
	}

	/**
	 * 需要在配置文件中配置id为writeSqlMapClient的bean
	 * 
	 */
	@Autowired(required=false)
	public void setWriteSqlMapClient(@Qualifier("writeSqlMapClient")SqlMapClient sqlMapClient) {
		writeSqlMapClient = sqlMapClient;
	}

	/**
	 * @return the readSqlMapClient
	 */
	public SqlMapClient getreadSqlMapClient() {
		return readSqlMapClient;
	}

	/**
	 * 需要在配置文件中配置id为writeSqlMapClient的bean
	 * 
	 */
	@Autowired(required=false)
	public void setReadSqlMapClient(@Qualifier("readSqlMapClient")SqlMapClient sqlMapClient) {
		readSqlMapClient = sqlMapClient;
	}

	/**
	 * 新增实体类
	 * 
	 * @param statement
	 * @param entity
	 * @return
	 * @throws SQLException 
	 */
	protected T save(String statement, T entity)  {
		String entityId = "";
		try {
			entityId = (String)writeSqlMapClient.insert(statement, entity);
		} catch (SQLException e) {
			logger.error("entity save error", e);
		}
		if(StringUtils.isNotBlank(entityId)) {
			entity.setId(entityId);
		}

		return entity;
	}

	/**
	 * 新增，主要用于新增非<code>DomainObject</code>的对象
	 * 
	 * @param statement
	 * @param entity
	 * @throws SQLException 
	 */
	protected void save(String statement, Object entity)  {
		try {
			writeSqlMapClient.insert(statement, entity);
		} catch (SQLException e) {
			logger.error("entity save error", e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param statement
	 * @param params
	 * @throws SQLException 
	 */
	protected void update(String statement, Object params)  {
		try {
			writeSqlMapClient.update(statement, params);
		} catch (SQLException e) {
			logger.error("entity update error", e);
		}
	}	

	/**
	 * 根据参数删除
	 * 
	 * @param statement
	 * @param params
	 * @throws SQLException 
	 */
	protected void delete(String statement, Object params)  {
		try {
			writeSqlMapClient.delete(statement, params);
		} catch (SQLException e) {
			logger.error("entity delete error", e);
		}
	}

	/**
	 * 根据参数取得<code>T</code>类型实体
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected T getEntity(String statement, Object params)  {
		Object o = null;
		try {
			o = readSqlMapClient.queryForObject(statement, params);
		} catch (SQLException e) {
			logger.error("entity get error", e);
		}
		return (T)o;
	}

	/**
	 * 根据根据参数取得任意类型实体
	 * 
	 * @param statement
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	protected Object getObject(String statement, Object params)  {
		Object o = null;
		try {
			o = readSqlMapClient.queryForObject(statement, params);
		} catch (SQLException e) {
			logger.error("entity get error", e);
		}
		return o;
	}

	/**
	 * 根据参数查询列表，可分页
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected List<T> query(String statement, QueryParams params)  {

		return (List<T>)queryEntities(statement, params);


	}

	/**
	 * 根据参数查询列表，可分页
	 * 
	 * @param statement
	 * @param params
	 * @return 如果查询不到结果，将返回一个<b>unmodifiable</b>的空List
	 * @throws SQLException 
	 */
	protected List queryEntities(String statement, QueryParams params) {
		if(params != null && params.getPaging() != null) {
			int records = 0;
			records = queryCount(statement, params);

			//如果查询出符合条件的记录数为0，那么就直接返回一个空的List，因为后面的已经没有执行的必要
			if(records == 0) {
				return EmptyObject.EMPTY_LIST;
			}

			params.getPaging().setRecords(records);
		}
		List rs = null;
		try {
			rs =  readSqlMapClient.queryForList(statement, params);
		} catch (SQLException e) {
			logger.error("resultset query error", e);
		}

		return rs;

	}

	/**
	 * 查询列表，不提供分页功能
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected List<T> query(String statement, Object params)  {
		List<T> rs = null;
		try {
			rs = readSqlMapClient.queryForList(statement, params);
		} catch (SQLException e) {
			logger.error("resultset query error", e);
		}
		return rs; 
	}

	/**
	 * 无参数查询列表，不提供分页功能
	 * 
	 * @param statement
	 * @return
	 * @throws SQLException 
	 */
	protected List<T> query(String statement)  {
		List<T> rs = null;
		try {
			rs = readSqlMapClient.queryForList(statement);
		} catch (SQLException e) {
			logger.error("resultset query error", e);
		}
		return rs;
	}

	/**
	 * 查询任意类型的对象列表。不局限于T类型的
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected List queryEntities(String statement, Object params)  {
		List rs = null;
		try {
			rs  = readSqlMapClient.queryForList(statement, params);
		} catch (SQLException e) {
			logger.error("resultset query error", e);
		}
		return rs;
	}

	/**
	 * 批量新增/修改/删除。注意批量新增时是无法正确的获取自增主键的值（批处理中最后一个新增可以获取正确的值，其它皆不可以），
	 * 所以如果需要获取自增主键的值，不应该使用该方法。
	 * 
	 * @param statement
	 * @param params
	 * @param batchSize <code>params.length</code>大于该参数的值时，将每batchSize个数据库操作进行一次批处理请求，
	 * 					而不是只进行一次批处理，以免一次性调用导致游标超出最大限制
	 * @throws BatchException 
	 * @throws SQLException 
	 */
	protected void batch(final String statement, final Object[] params, int batchSize){
		if(params.length <= batchSize) {
			batch(statement, params);
			return;
		}

		List batches = new ArrayList(batchSize);
		for(int i = 0; i < params.length; i++) {
			batches.add(params[i]);
			if((i > 0 && (i + 1) % batchSize == 0) || (i == (params.length - 1))) {
				batch(statement, batches.toArray(new Object[batches.size()]));
				batches = new ArrayList(batchSize);
			}
		}
	}

	/**
	 * 该方法将所有数据库操作作为一次批处理请求。<br>
	 * <b>请注意，如果数据量过大，请调用{@link #batch(String, Object[], int)}，以免一次性调用导致游标超出最大限制。</b>
	 * 
	 * @param statement
	 * @param params
	 * @throws SQLException 
	 * @throws BatchException 
	 * @see #batch(String, Object[], int)
	 */
	protected void batch(final String statement, final Object[] params)  {
		try {
			writeSqlMapClient.startTransaction();
			writeSqlMapClient.startBatch ();
			for(Object o:params){
				writeSqlMapClient.update(statement, o); 
			}
			List batchResultList = writeSqlMapClient.executeBatchDetailed(); 
			for(int i=0; i<batchResultList.size();i++) 
			{ 
				System.out.println("UpdatedStatus : " + i + " " + batchResultList.get(i));    // this gives me 0 count even though 2 records get updated 
			}   
			writeSqlMapClient.commitTransaction(); 
		} catch (SQLException e) {
			logger.error("batch execute error", e);
		} catch (BatchException e) {
			logger.error("batch execute error", e);
		} 



	}

	/**
	 * 根据参数判断该记录是否已存在（逻辑上存在）
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected boolean isExistEntity(String statement, Object params)  {
		boolean b = true;
		try {
			b = (Integer)readSqlMapClient.queryForObject(statement, params) > 0;
		} catch (SQLException e) {
			logger.error("sql execute error", e);
		}
		return b;
	}

	/**
	 * 取得指定的statement的完全限定名称。形式为<code>namespace</code> + "." + <code>statement</code>
	 * 
	 * @param namespace
	 * @param statement
	 * @return
	 */
	protected String getQualifiedName(String namespace, String statement) {
		return new StringBuffer().append(namespace).append(".").append(statement).toString();
	}

	/**
	 * 取得指定的statement的完全限定名称。该方法以泛型<code>T</code>的实际类型的完全限定名 + "." + <code>statement</code>。这就要求在
	 * 书写iBatis配置文件时，namespace必须写成“泛型<code>T</code>的实际类型的完全限定名”。<br>
	 * 例如，如果有DAO实现类ClientApplicationDao&lt;ClientApplication&gt;，ClientApplication位于com.tudou.api.entity下，
	 * 那么调用该方法将返回com.tudou.api.entity.ClientApplication.xxx。
	 * 
	 * @param statement
	 * @return
	 */
	protected String getQualifiedName(String statement) {

		/**
		 * 避免每次都去获取
		 */
		if(StringUtils.isBlank(entityClass)) {
			String entityClz = DomainObject.class.getName();
			Type superClass = getClass().getGenericSuperclass();
			if(superClass instanceof ParameterizedType) {
				ParameterizedType genericType = (ParameterizedType)superClass;
				Type[] typeArgs = genericType.getActualTypeArguments();
				if(typeArgs.length > 0) {
					entityClz = ((Class<T>)typeArgs[0]).getName();
				}
			}

			entityClass = entityClz;
		}

		int bufSize = ((entityClass == null ? 0 : entityClass.length()) + (statement == null ? 0 : statement.length()) + 1);
		return new StringBuilder(bufSize).append(entityClass).append(".").append(statement).toString();
	}

	/**
	 * 根据条件查询整数结果。
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	protected int uniqueIntResult(String statement, Object params)  {
		Integer i = 0;
		try {
			if(params == null) {
				i =  (Integer)readSqlMapClient.queryForObject(statement);
			}			
			i = (Integer)readSqlMapClient.queryForObject(statement, params);

		}  catch (SQLException e) {
			logger.error("sql execute error", e);
		}

		return i;
	}

	/**
	 * 查询符合条件的记录数，仅供分页查询调用。
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @throws SQLException 
	 */	
	private int queryCount(String statement, QueryParams params)  {
		Integer i = 0;
		try {
			if(params == null) {
				i = (Integer)readSqlMapClient.queryForObject(statement + COUNT_STATEMENT_SUFFIX);
			}

			i = (Integer)readSqlMapClient.queryForObject(statement + COUNT_STATEMENT_SUFFIX, params);

		}  catch (SQLException e) {
			logger.error("sql execute error", e);
		}
		return i;
	}

}
