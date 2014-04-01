<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx}/css/use_0226.css" rel="stylesheet" >
<title>任务优先级</title>
<jsp:include page="../head.jsp"></jsp:include>
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
</head>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<body>
<s:if test='createResult == "1"'>
<h4 class="form-signin-heading" style="color:red">创建任务优先级成功！</h4>
</s:if>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">新建任务优先级</h4>
		<form id="roleForm" class="form-horizontal" action="${ctx}/mission/createpri.action" method="post" >
			<fieldset>
			<div class="form-group">
				<label for="pri_name" class="control-label col-md-3">优先级名称:</label>
				<div class="col-md-5 ">
       		 	 	<input type="text" class="form-control col-md-2" id="priName" name="priInfo.priName" check-type="required"  autofocus />
				</div>
			</div>
			<div class="form-group">
				<label for="pri_Desc" class="control-label col-md-3">优先级描述:</label>
				<div class="col-md-5 textarea">
       		 	 	<textarea class="text1" id="priDesc" name="priInfo.priDesc" ></textarea> 
				</div>
			</div>
			 <button type="submit" class="btn btn-default control-label">提交</button>
			 </fieldset>
		</form>
		</div>
	</div>
</body>

</html>