<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LayOut Login</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${ctx}/css/icon.css" rel="stylesheet"/>
<link href="${ctx}/css/bootstrap-theme.min.css" rel="stylesheet"  />

<link href="${ctx}/css/signin.css" rel="stylesheet">

<script language="JavaScript" type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/js/login/login.js"></script>

<!-- [if lt IE 9]>
	<script src="js/html5.js" ></script>
<![endif]-->

</head>

<body>
	<div class="container">
		 <form class="form-signin" role="form" action="${ctx}/user/login.action" method="post">
	 <h4 class="form-signin-heading">请 登 陆</h4>
       	<fieldset>
        <input type="text" name="userInfo.username" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" name="userInfo.pwd" class="form-control" placeholder="密码" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 请记住
        </label>
        <div class="row">
        <div class="col-sm-offset-2  col-sm-4">
        <button class="btn " type="button" id="regBtn">注册</button>
        </div>
        <div class="col-sm-4">
        <button class="btn btn-primary" type="submit">登陆</button>
      	 </div>
      	</div>
      	</fieldset>
      </form>
      <h4>${msg}</h4>
	</div>
</body>
</html>