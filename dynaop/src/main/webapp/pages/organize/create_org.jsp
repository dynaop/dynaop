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
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
</head>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<script type="text/javascript">
$(function() {
$(document).ready(function() {
	$("#e1").select2({ minimumResultsForSearch: -1 });
	$("#erole").select2({ minimumResultsForSearch: -1 });
	
}); 
});
</script>
<body>
<s:property value="createResult"/>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">创建组织架构</h4>
		<form id="roleForm" class="form-horizontal" action="${ctx}/organize/create.action" method="post" >
		
			<fieldset>
					<div class="form-group">
						<label for="orgFname" class="col-md-2 control-label"><font style="color: red">*</font>架构名：</label>
						<div class="col-md-8">
							<input type="text" class="form-control col-md-2" id="orgFname" name="orgInfo.orgFname" required autofocus />
						</div>
					</div>
					<div class="form-group">
						<label for="orgDesc" class="col-md-2 control-label">架构描述：</label>
						<div class="col-md-8 textarea">
							<textarea class="text1" id="orgDesc" name="orgInfo.orgDesc"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="orgParentID" class="control-label col-md-2">上级:</label>
						<div class="col-md-5 ">
							<select id="e1" class="populate select2-offscreen " name="orgInfo.orgParentID" tabindex="-1">
							<s:if test="orgParentList == null||orgParentList.size<1">
								<option value=""/>无上级</option>
							</s:if>
							<s:else>
								<option value=""/>无上级</option>
								<s:iterator value="orgParentList" id="list" status="index">
									<option value="<s:property value="#list.id"/>"><s:property value="#list.orgFname" /></option>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.orgParentID" id="orgInfo.orgParentID"/>
						</div>
					</div>
					<div class="form-group">
						<label for="roleID" class="control-label col-md-2">角色:</label>
						<div class="col-md-5 ">
							<select id="erole" class="populate select2-offscreen " id="orgInfo.roleID" name="orgInfo.roleID" tabindex="-1" >
							<s:if test="roleList == null||roleList.size<1">
								<option value="" >无角色</option>
							</s:if>
							<s:else>
								<s:iterator value="roleList" id="rlist" status="index">
									<option value="<s:property value="#rlist.id"/>"><s:property value="#rlist.roleName" /></option>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.roleID" id="orgInfo.roleID"/>
						</div>
					</div>
					<button type="submit" class="btn btn-default control-label">提交</button>
			 </fieldset>
		</form>
		</div>
	</div>
</body>
</html>