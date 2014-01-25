<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LayOut Demo</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/icon.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-theme.min.css" rel="stylesheet" />


<script language="JavaScript" type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/login/reg.js"></script>

<!-- [if lt IE 9]>
	<script src="${ctx}/js/html5.js" ></script>
<![endif]-->

</head>

<body>

	<div class="container">
		<div class="col-lg-4">
			<h4 class="col-sm-offset-1 form-signin-heading">请输入注册信息</h4>
			<form class="form-horizontal" action="${ctx}/user/reg.action" method="post">

				<fieldset>
					<div class="form-group">
						<label for="focusedInput" class="col-sm-4 control-label" for="focusedInput">用户名(*)：</label>
						<input id="focusedInput" class="col-sm-4" name="userInfo.username" type="text" required autofocus> 
					</div>
					<div class="form-group">
						<label for="pwd" class="col-sm-4 control-label">密 码(*)：</label> 
						<input type="password" class="col-sm-4" id="pwd"  name="userInfo.pwd" required>
					</div>
					<div class="form-group">
						<label for="rePwd" class="col-sm-4 control-label">确认密码(*)：</label> 
						<input	type="password" class="col-sm-4" id="rePwd" required>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Email：</label> 
						<input type="text" class="col-sm-4" name="userInfo.email">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">QQ：</label> 
						<input type="text" class="col-sm-4" name="userInfo.qq">
					</div>
					<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
						 <button class="btn" type="reset">重置</button>
						<button class="btn btn-primary" type="submit">注册</button>
					</div>
				</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>