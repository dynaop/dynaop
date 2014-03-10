<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>创建任务</title>
<jsp:include page="../head.jsp"></jsp:include>
<link href="${ctx}/css/use_0226.css" rel="stylesheet" >
</head>
<body>
<s:property value="createResult"/>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">创建角色</h4>
		<form id="roleForm" class="form-horizontal" action="${ctx}/role/create.action" method="post" >
		
			<fieldset>
			<div class="form-group">
		         <label for="role_name" class="col-md-2 control-label"><font style="color:red">*</font>角色名：</label>
	         	 <div class="col-md-8">
	         	 	<input type="text" class="form-control col-md-2" id="role_name" name="roleInfo.roleName" required autofocus />
	         	 </div>
	        </div>
	        <div class="form-group">
		         <label for="role_desc" class="col-md-2 control-label">角色描述：</label>
	         	 <div class="col-md-8 textarea">
                 	<textarea class="text1" id="roleDesc" name="roleInfo.roleDesc" ></textarea> 
	         	 </div>
	        </div>
	        
			 <button type="submit" class="btn btn-default control-label">提交</button>
			 </fieldset>
		</form>
		</div>
	</div>
</body>
</html>