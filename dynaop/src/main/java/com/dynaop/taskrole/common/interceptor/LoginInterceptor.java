/**
 * 
 */
package com.dynaop.taskrole.common.interceptor;


import org.apache.commons.lang3.StringUtils;

import com.dynaop.taskrole.common.Constants;
import com.dynaop.taskrole.common.util.LogUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author huangjianghua(ivanhuang81@gmail.com)
 * @date 2014-1-13
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final LogUtils logger = LogUtils.getInstance(LoginInterceptor.class);


	@Override
	protected String doIntercept(ActionInvocation invocation)
			throws Exception {
//		if (logger.getLog().isTraceEnabled()) {
		      StringBuilder sb = new StringBuilder();
		      sb.append("action名称:");
		      sb.append(invocation.getProxy().getActionName());
		      logger.info(sb.toString());
//		    }
		
		ActionContext ac = invocation.getInvocationContext();
		String user = (String)ActionContext.getContext().getSession().get(Constants.sessionKey);
		if( StringUtils.isNotBlank(user)||invocation.getProxy().getActionName().equals("hasUser")){
			return invocation.invoke();
		}
		
		return Action.LOGIN;
	}

}
