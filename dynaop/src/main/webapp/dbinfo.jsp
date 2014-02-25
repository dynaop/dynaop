<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*,com.baidu.bae.api.util.BaeEnv" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Hello World</title>
  </head>
  <body>
    <%
        //（1）指定服务地址，其中dbname需要自己修改
        //String dbUrl = "jdbc:mysql://sqld.duapp.com:4050/dbname";
        //（2）直接从请求header中获取ip、端口、用户名和密码信息
	//String host = request.getHeader("BAE_ENV_ADDR_SQL_IP");
	//String port = request.getHeader("BAE_ENV_ADDR_SQL_PORT");
	//String username = request.getHeader("BAE_ENV_AK");
	//String password = request.getHeader("BAE_ENV_SK");
       //（3）从线程变量BaeEnv接口获取ip、端口、用户名和密码信息
	String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
	String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
	String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
	String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
	String driverName = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://";
	String serverName = host + ":" + port + "/";
 
	//从平台查询应用要使用的数据库名
	String databaseName = "VYHfRoJKgYiCyGpyZetX";
	String connName = dbUrl + serverName + databaseName;
	String dbinfo="username:"+username+",password="+password+",url="+connName;
     
      out.println(dbinfo);
	
 %>
  </body>
</html>