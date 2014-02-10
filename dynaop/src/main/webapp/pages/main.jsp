<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="UTF-8">
	<title>Full Layout - jQuery EasyUI Demo</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="easyui-layout" style="width:100%;height:100%;">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
		<ul class="easyui-tree" data-options="
			url:'${ctx}/dynaop/menuTree.action',
			method:'get',
			animate:true,
			dnd:true,
			lines:true,
			onClick: function(node){
				if(!node.children){
					addTab(node.text,node.url);
					}
			}			
			"></ul>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'" style="width:auto;height:auto;" >
		<div id="tt" class="easyui-tabs" style="width:auto;height:auto;" data-options="tools:'#tab-tools'" >
				
			</div>
	</div>
	<script type="text/javascript">
	
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;min-height:430px;overflow:hidden; " ></iframe>';
				//var content = url;
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