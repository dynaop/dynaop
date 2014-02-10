<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LayOut Login</title>
<jsp:include page="../head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/login/login.js"></script>
</head>

<body>
	<div class="container">
	<div class="col-lg-4 col-sm-offset-4">
		 <form class="form-signin" role="form" action="${ctx}/user/login.action" method="post">
	 <h4 class="form-signin-heading">请 登 陆</h4>
       	<fieldset>
        <input type="text" name="userInfo.username" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" name="userInfo.pwd" class="form-control" placeholder="密码" required>
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
	</div>
</body>
</html>