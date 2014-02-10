package com.dynaop.taskrole.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LogUtils {
	
	private Log log; 
	
	private LogUtils(Class<?> clazz){
		log = LogFactory.getLog(clazz);
	}
	
	private LogUtils(String clazz){
		log = LogFactory.getLog(clazz);
	}
	
	public static LogUtils getInstance(Class<?> clazz){
		return new LogUtils(clazz);
	}
	
	public static LogUtils getInstance(String clazz){
		return new LogUtils(clazz);
	}
	
	public void trace(String s){
		if(log.isTraceEnabled()){
			log.trace(s);
		}
	}
	
	public void debug(String s){
		if(log.isDebugEnabled()){
			log.debug(s);
		}
	}
	
	public void info(String s){
		if(log.isInfoEnabled()){
			log.info(s);
		}
	}
	
	public void warn(String s){
		if(log.isWarnEnabled()){
			log.warn(s);
		}
	}
	
	public void error(String s){
		if(log.isErrorEnabled()){
			log.error(s);
		}
	}
	
	public void fatal(String s){
		if(log.isFatalEnabled()){
			log.fatal(s);
		}
	}
	
	public void trace(String s , Throwable e){
		if(log.isTraceEnabled()){
			log.trace(s, e);
		}
	}
	
	public void debug(String s, Throwable e){
		if(log.isDebugEnabled()){
			log.debug(s, e);
		}
	}
	
	public void info(String s, Throwable e){
		if(log.isInfoEnabled()){
			log.info(s, e);
		}
	}
	
	public void warn(String s, Throwable e){
		if(log.isWarnEnabled()){
			log.warn(s, e);
		}
	}
	
	public void error(String s, Throwable e){
		if(log.isErrorEnabled()){
			log.error(s, e);
		}
	}
	
	public void fatal(String s, Throwable e){
		if(log.isFatalEnabled()){
			log.fatal(s, e);
		}
	}
	
	public void trace(Throwable e){
		if(log.isTraceEnabled()){
			log.trace(e);
		}
	}
	
	public void debug(Throwable e){
		if(log.isDebugEnabled()){
			log.debug(e);
		}
	}
	
	public void info(Throwable e){
		if(log.isInfoEnabled()){
			log.info(e);
		}
	}
	
	public void warn(Throwable e){
		if(log.isWarnEnabled()){
			log.warn(e);
		}
	}
	
	public void error(Throwable e){
		if(log.isErrorEnabled()){
			log.error(e);
		}
	}
	
	public void fatal(Throwable e){
		if(log.isFatalEnabled()){
			log.fatal(e);
		}
	}
	
	public Log getLog(){
		return this.log;
	}
}
