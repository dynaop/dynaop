<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="UTF-8">
	<title>2Full Layout - jQuery EasyUI Demo</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="easyui-layout" style="width:100%;height:100%;">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'west'" style="width:250px;padding:0px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true" style="width:250px;padding:0px;"></div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div id="center" data-options="region:'center',title:'Center'" style="width:auto;heigt:auto!important;padding:0px"  >
		<div id="tt" class="easyui-tabs"  data-options="tools:'#tab-tools'" style="width:auto;height:auto!important"></div>
	</div>
	<script type="text/javascript">
	 $(function(){
	        var url = g_ctx+'/dynaop/menuTree.action';
	        $.post(url,function(da){
	            menu(da);
	        });             
	        
	    });
	function menu(TreeModel){
        for(var i = 0; i < TreeModel.length;i++){
            $('#menu').accordion('add', {
                title: TreeModel[i].text,
                content: TreeP(TreeModel[i].child),
                selected: false
            });
        }
    }
    function TreeP(model){
        var text = '';
        for(var i=0;i<model.length;i++){
        	var tmp = model[i];
            text += '<a href="#" onclick="addTab(\''+tmp.text+'\',\''+tmp.url+'\')">'+tmp.text+'</a></br>';
        }
        return text;
    }
		function addTab(title,childObj){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+childObj+'" style="width:100%;height:100%;min-height:200px;overflow:hidden; " ></iframe>';
				
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