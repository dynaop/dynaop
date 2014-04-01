<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${ctx}/css/use_0226.css">
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
<title>用户</title>
<jsp:include page="../head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<script type="text/javascript">
var op_id = undefined;
function setUserID(userID){
	alert(userID);
	op_id = userID;
	$('#modal4del').modal('show');
}
function deluser(){
	 if (op_id == undefined){return ;}
	 $.get("${ctx}/userinfo/deluser.action?rid="+op_id,function(result){
	    $('#'+op_id+'').parent().parent().remove();
	    $('#modal4del').modal('hide');
	    op_id = undefined;
	});
}
$(document).ready(function() {
	$("#modal4mod").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	});
});
</script>
</head>
<body>
<div id="totalRecord" style="display:none">
<span id="totalRecord"><s:property value="totalRecord"/></span>
<span id="totalPages"><s:property value="totalPages"/></span>
<span id="currentPage"><s:property value="currentPage"/></span> 
</div>
 <legend>用户列表</legend>
	<table id="tableid" class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th style="align:center">用户名</th>
				<th style="align:center">操作</th>
			</tr>
		</thead>
		<tbody id="tbodyid" >
			<s:iterator value="userList"  id="list" status="index">
			<tr>
				<td><s:property value="#list.username"/></td>
				<td><a id="<s:property value="#list.id"/>" href="${ctx}/userinfo/turn2updateuser.action?rid=<s:property value="#list.loginId"/>&currentPage=${currentPage}"
							role="button" class="btn" data-toggle="modal" data-target="#modal4mod">修改</a>
					<a id="<s:property value="#list.id"/>" href="#modal4del" onclick="setUserID('<s:property value="#list.loginId"/>');" per="button" class="btn" data-toggle="modal" data-target=".modal-4-del">删除</a>
				</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div style="align:center">
	    <ul id='splitPage'></ul>
	</div>
	<div class="modal fade modal-4-mod" id="modal4mod" per="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<!--  -->
			
			<!--  -->
		</div>
	</div>
	
	<div class="modal fade modal-4-del" id="modal4del" per="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">删除用户</h4>
				</div>
				<div class="modal-body">
					<h3>确认删除用户？</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="deluser();">确认</button>
				</div>
			</div>
		</div>
	</div>



</body>

<script type="text/javascript">
	var offset = 0;
	$(document).ready(function() {
		offset = 0;
		var totalPages = $('#totalPages')[0].innerHTML;
		var totalRecord = $('#totalRecord')[0].innerHTML;
		var currentPage = $('#currentPage')[0].innerHTML;

		var element = $('#splitPage');

		var options = {
			bootstrapMajorVersion : 3,
			alignment : 'right',
			currentPage : currentPage,
			numberOfPages : 10,
			totalPages : totalPages,
			tooltipTitles : function(type, page, current) {
				switch (type) {
				case "first":
					return "首页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "尾页";
				case "page":
					return "第" + page + "页";
				}
			},
			shouldShowPage : function(type, page, current) {
				switch (type) {
				default:
					return true;
				}
			},
			pageUrl : function(type, page, current) {
				return "${ctx}/userinfo/turn2userlist.action?currentPage=" + page;
			}

		};

		element.bootstrapPaginator(options);
	});
</script>
</html>