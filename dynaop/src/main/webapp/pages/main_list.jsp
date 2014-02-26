<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="UTF-8">
	<title>1Full Layout - jQuery EasyUI Demo</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="easyui-layout" style="width:100%;height:100%;padding:0px">
<!-- 顶部 -->
	<div id="north" data-options="region:'north',border:false" style="height:62px;background:#B3DFDA;padding:0px"> 
	<div id="out" class="row" style="width:100%;height:60px;background:#B3DFDA;padding:0px" data-options=",fit:true">
		<div id="logo" class="head_height col-md-3" style="width:70px;"><img src="${ctx}/images/sys_logo.jpg"/></div>
		<div id="sys_name" class="head_height col-md-3" style="margin-left:15px" ><h3 style="color:blue">dynaop应用管理系统</h3></div>
		<div id="user_info" class="head_height col-md-6" >
			<div id="user_info_1" class="head_height row" >
				<div class="head_height col-md-4" style="font-size: 12px;font-family: 新宋体;font-weight: bold;padding:5px">
					<p>姓名：ivan</p>
					<p>角色：员工</p>
				</div>
				<div id="user_mission_out" class="head_height col-md-7">
					<font style="font-family: 新宋体;font-weight: bold ">当前任务  XXXXX 的总投入时间为  8 小时</font><br>
					<font size="1" color="red">用时率</font>
								<canvas id="timeChart" width="40px" height="40px" style="vertical-align:middle" ></canvas>
					<font size="1" color="red">完成率</font>
								<canvas id="completeChart" width="40px" height="40px" style="vertical-align:middle" ></canvas>			
				</div>	
			</div>
		</div>
		<div id="exit" class="col-md-2 head_exit"><a href="">退出系统</a></div>
	</div>
	
	</div>
	<!-- 左侧 -->
	<div data-options="region:'west',split:true,title:'west'" style="width:250px;padding:0px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true" style="width:250px;padding:0px;"></div>
	</div>
	<!-- 右侧 
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	-->
	<!-- 底部 
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	-->
	<!-- 中间 -->
	<div id="center" data-options="region:'center'" style="width:auto;heigt:auto!important;padding:0px"  >
		<div id="tt" class="easyui-tabs"  data-options="tools:'#tab-tools',fit:true" style="width:auto;height:auto!important"></div>
	</div>
	<script type="text/javascript">
	 $(function(){
	        var url = g_ctx+'/dynaop/menuTree.action';
	        $.post(url,function(da){
	            menu(da);
	        });             
	        mission_chart();
	        
	    });
	 function mission_chart(){
		 var timeData = [
		                	{
		                		value: 50,
		                		color:"#F38630"
		                	},
		                	{
		                		value : 50,
		                		color : "#E0E4CC"
		                	}			
		                ];
		        var timeCtx = $("#timeChart").get(0).getContext("2d");
		       var tChart = new Chart(timeCtx).Pie(timeData);
		   
		       var cData = [
			                	{
			                		value: 30,
			                		color:"#F38630"
			                	},
			                	{
			                		value : 70,
			                		color : "#E0E4CC"
			                	}			
			                ];
			        var cCtx = $("#completeChart").get(0).getContext("2d");
			       var cChart = new Chart(cCtx).Pie(cData);        
	 }
	 
	function menu(TreeModel){
        for(var i = 0; i < TreeModel.length;i++){
            $('#menu').accordion('add', {
                title: TreeModel[i].menu_name,
                content: TreeP(TreeModel[i].child),
                selected: false
            });
        }
    }
    function TreeP(model){
        var text = '';
        for(var i=0;i<model.length;i++){
        	var tmp = model[i];
            text += '<a href="#" onclick="addTab(\''+tmp.menu_name+'\',\''+tmp.menu_uri+'\')">'+tmp.menu_name+'</a></br>';
        }
        return text;
    }
		function addTab(title,childObj){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
			//	var content = '<iframe scrolling="auto" frameborder="0"  src="${ctx}'+childObj+'" style="width:100%;height:100%;min-height:200px;overflow:hidden; " ></iframe>';
				var content = '<iframe width="100%" height="100%"  src="${ctx}'+childObj+'" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" frameborder="0"  scrolling="yes" style="overflow-y: auto; overflow-x: auto;"> </iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
		
	</script>
</body>
</html>