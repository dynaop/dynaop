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
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
</head>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<body>
<s:if test='createResult == "1"'>
<h4 class="form-signin-heading" style="color:red">设置默认角色成功！</h4>
</s:if>
	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">设置默认角色</h4>
		<form id="roleForm" class="form-horizontal" action="${ctx}/role/setdefault.action" method="post" >
			
			<fieldset>
			<div class="form-group">
						<label for="roleid" class="control-label col-md-3">角色:</label>
						<div class="col-md-5 ">
							<select id="erole" class="populate select2-offscreen" style="width:100%"  id="roleid" name="roleid" tabindex="-1" >
							<s:if test="roleList == null||roleList.size<1">
								<option value="" >无角色</option>
							</s:if>
							<s:else>
								<option value="" >无角色</option>
								<s:iterator value="roleList" id="rlist" status="index">
									<s:if test="#rlist.id == roleid">
										<option value="<s:property value="#rlist.id"/>" selected><s:property value="#rlist.roleName" /></option>
									</s:if>
									<s:else>
										<option value="<s:property value="#rlist.id"/>"><s:property value="#rlist.roleName" /></option>
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
$(document).ready(function() {
	$("#erole").select2({ minimumResultsForSearch: -1 });
}); 
</script>
</html>