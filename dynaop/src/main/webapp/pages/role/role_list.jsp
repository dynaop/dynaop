<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${ctx}/css/use_0226.css">
<title>任务</title>
<jsp:include page="../head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">
var op_id = undefined;
function setRoleID(roleID){
	op_id = roleID;
	$('#modal4del').modal('show');
}
function setRoleID4mod(roleID,name,desc){
	op_id = roleID;
	$('#roleName').val(name);
	$('#roleID').val(roleID);
	$('#roleDesc').val(desc);
	$('#modal4mod').modal('show');
}
function delRole(){
	 if (op_id == undefined){return ;}
	 $.get("${ctx}/role/delrole.action?rid="+op_id,function(result){
	    $('#'+op_id+'').parent().parent().remove();
	    $('#modal4del').modal('hide');
	    op_id = undefined;
		offset = offset+1;
	});
}
function modRole(){
	
	return;
}
</script>
</head>
<body>
<div id="totalRecord" style="display:none">
<span id="totalRecord"><s:property value="totalRecord"/></span>
<span id="totalPages"><s:property value="totalPages"/></span>
<span id="currentPage"><s:property value="currentPage"/></span> 
</div>
 <legend>任务列表</legend>
	<table id="tableid" class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th style="align:center">角色名</th>
				<th style="align:center">操作</th>
			</tr>
		</thead>
		<tbody id="tbodyid" >
			<s:iterator value="roleList"  id="list" status="index">
			<tr>
				<td><s:property value="#list.roleName"/></td>
				<td><a id="<s:property value="#list.id"/>" href="#modal4mod" onclick="setRoleID4mod('<s:property value="#list.id"/>','<s:property value="#list.roleName"/>','<s:property value="#list.roleDesc"/>');" role="button" class="btn" data-toggle="modal" data-target=".modal-4-mod">修改</a>
					<a id="<s:property value="#list.id"/>" href="#modal4del" onclick="setRoleID('<s:property value="#list.id"/>');" role="button" class="btn" data-toggle="modal" data-target=".modal-4-del">删除</a>
				</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div style="align:center">
	    <ul id='splitPage'></ul>
	</div>
	<div class="modal fade modal-4-mod" id="modal4mod" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="roleForm" class="form-horizontal" action="${ctx}/role/modrole.action" method="post" >
				<input type="hidden" name="currentPage" value="${currentPage}"> 
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改角色</h4>
					</div>
					<div class="modal-body">
						<fieldset>
							 <input type="hidden" id="roleID" name="roleInfo.id" value=""/>
							 <div class="form-group">
							 	 <label for="role_name" class="col-md-3 control-label"><font style="color:red">*</font>角色名：</label>
							 	 <div class="col-md-7">
	  								<input type="text" class="form-control col-md-3" id="roleName" name="roleInfo.roleName" required autofocus />
							 	 </div>
							 </div>
							 <div class="form-group">
								 <label for="role_desc" class="col-md-3 control-label">角色描述：</label>
								 <div class="col-md-7 textarea">
	                 			 	<textarea class="text1" id="roleDesc" name="roleInfo.roleDesc" ></textarea>
	                 			 </div>
                 			 </div> 
						</fieldset>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" >确认</button>
					</div><!-- onclick="modRole();" -->
				</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade modal-4-del" id="modal4del" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">删除角色</h4>
				</div>
				<div class="modal-body">
					<h3>确认删除角色？</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="delRole();">确认</button>
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
				return "${ctx}/role/rolelist.action?currentPage=" + page;
			}

		};

		element.bootstrapPaginator(options);
	});
</script>
</html>