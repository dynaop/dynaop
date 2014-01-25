<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>

  <title>Bootstrap 3, from LayoutIt!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="${ctx}/less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="${ctx}/less/responsive.less" type="text/css" /-->
	<!--script src="${ctx}/js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="${ctx}/js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="${ctx}/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="${ctx}/img/favicon.png">
  
	<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/scripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-4 column">
					<h3 class="text-center">
						DynaOp  LOGO						
					</h3>
				</div>
				<div class="col-md-8 column">
					<h4 class="text-right">
						当前登录用户：ivan 退出
					</h4>
				</div>
			</div>
		</div>
	</div>
	<hr/>
	<div class="row clearfix">
		<div class="col-md-2 column">
						<div class="panel-group" id="panel-381977">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#panel-381977" href="#panel-element-236207">系统功能</a>
					</div>
					<div id="panel-element-236207" class="panel-collapse in">
						<div class="panel-body">
							用户管理
						</div>
						<div class="panel-body">
							菜单管理
						</div>
						<div class="panel-body">
							权限管理
						</div>
						<div class="panel-body">
							系统角色管理
						</div>
						<div class="panel-body">
							系统权限分配
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-381977" href="#panel-element-393568">项目管理</a>
					</div>
					<div id="panel-element-393568" class="panel-collapse collapse">
						<div class="panel-body">
							成员管理
						</div>
						<div class="panel-body">
							角色管理
						</div>
						<div class="panel-body">
							成员角色管理
						</div>
						<div class="panel-body">
							任务管理
						</div>
						<div class="panel-body">
							动态任务管理
						</div>
						<div class="panel-body">
							标准任务管理
						</div>
						<div class="panel-body">
							项目管理
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-10 column">
			<div class="tabbable" id="tabs-903253">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-sys" data-toggle="tab">系统介绍</a>
					</li>
					<li >
						<a href="#panel-867990" data-toggle="tab">Section 1</a>
					</li>
					<li>
						<a href="#panel-142019" data-toggle="tab">Section 2</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-sys">
						<p>
							
							运营管理与其他的项目管理不同的，更强调运营管理的全方位角度，主要的区别包括：
? 项目的角度: 项目创建，分解，需求细化，讨论，时间分析，排期，完成后的维护，修改等等，这些都要人力投入，许多项目管理软件只管执行部分或开发部分，没有达到运营管理的高度
? 角色的角度：每个成员的每个时刻必须和某个任务挂钩，这样才能知道组织的运营效率，才能知道人力流投入到哪里了，才能在整个组织的高度提高运营效率
						</p>
					</div>
					<div class="tab-pane" id="panel-867990">
						<p>
							I'm in Section 1.
						</p>
					</div>
					<div class="tab-pane" id="panel-142019">
						<p>
							Howdy, I'm in Section 2.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr/>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center">
					 Copyright@ 2014 DynaOp			
					</h3>
			
		</div>
	</div>
</div>
</body>
</html>
