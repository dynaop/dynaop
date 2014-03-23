<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新建权限</title>
<jsp:include page="../head.jsp"></jsp:include>
<link href="${ctx}/css/use_0226.css" rel="stylesheet" >
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
</head>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<body>
<s:if test='createResult == "1"'>
<h4 class="form-signin-heading" style="color:red">新建权限成功！</h4>
</s:if>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">新建权限</h4>
		<form id="perForm" class="form-horizontal" action="${ctx}/permission/create.action" method="post" >
		
			<fieldset>
			<div class="form-group">
		         <label for="per_name" class="col-md-2 control-label"><font style="color:red">*</font>权限名：</label>
	         	 <div class="col-md-8">
	         	 	<input type="text" class="form-control col-md-2" id="per_name" name="perInfo.perName" required autofocus />
	         	 </div>
	        </div>
	        <div class="form-group">
		         <label for="per_desc" class="col-md-2 control-label">权限描述：</label>
	         	 <div class="col-md-8 textarea">
                 	<textarea class="text1" id="perDesc" name="perInfo.perDesc" ></textarea> 
	         	 </div>
	        </div>
	        
	        <div class="form-group">
						<label for="perID" class="control-label col-md-2">菜单:</label>
						<div class="col-md-5 ">
							<select id="emenu" class="multiSelect populate select2-offscreen"  name="perInfo.menuIDS" style="width:60%"  multiple="true" >
							<s:if test="menuList == null||menuList.size<1">
								<option value="" >无菜单</option>
							</s:if>
							<s:else>
								<s:iterator value="menuList" id="rlist" status="index">
									<s:if test='#rlist.parent_id == null || #rlist.parent_id == ""'>
										<optgroup label='<s:property value="#rlist.menu_name_zh" />'><s:property value="#rlist.menu_name_zh" />
									</s:if>
									<s:else>
										<option value="<s:property value="#rlist.menu_id"/>"><s:property value="#rlist.menu_name_zh" /></option>
									</s:else>
								</s:iterator>
							</s:else>
							</select>
						</div>
			</div>
	        
			 <button type="submit" class="btn btn-default control-label">提交</button>
			 </fieldset>
		</form>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function() {
$(document).ready(function() {
	$("#emenu").select2({
	});
}); 
});
</script>
</html>