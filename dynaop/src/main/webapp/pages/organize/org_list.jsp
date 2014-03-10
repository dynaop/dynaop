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
<title>任务</title>
<jsp:include page="../head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<script type="text/javascript">
var op_id = undefined;
function setOrgID(orgID){
	op_id = orgID;
	$('#modal4del').modal('show');
}
function setOrgID4mod(obj){
	$('#modal4mod').modal('hide'); 
	/* 	 $.get("${ctx}/organize/sinorg.action?rid="+obj,function(result){
		 $('#orgName').val(result.orgFname);
		 
		});
	 
	

	$('#modal4mod').modal('show');  */
} 
function delOrg(){
	 if (op_id == undefined){return ;}
	 $.get("${ctx}/organize/delorg.action?rid="+op_id,function(result){
	    $('#'+op_id+'').parent().parent().remove();
	    $('#modal4del').modal('hide');
	    op_id = undefined;
	});
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
				<th style="align:center">组织机构名</th>
				<th style="align:center">上级机构</th>
				<th style="align:center">角色</th>
				<th style="align:center">操作</th>
			</tr>
		</thead>
		<tbody id="tbodyid" >
			<s:iterator value="orgList"  id="list" status="sta">
			<tr>
				<td><s:property value="#list.orgFname"/></td>
				<td><s:property value="#list.orgParentName"/></td>
				<td><s:property value="#list.roleName"/></td>
				<td><a id="<s:property value="#list.id"/>" href="#modal4mod" onclick="setOrgID4mod(this.id);" role="button" class="btn" data-toggle="modal" data-target=".modal-4-mod">修改</a>
					<a id="<s:property value="#list.id"/>" href="#modal4del" onclick="setOrgID('<s:property value="#list.id"/>');" role="button" class="btn" data-toggle="modal" data-target=".modal-4-del">删除</a>
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
				<form id="orgForm" class="form-horizontal" action="${ctx}/organize/modorg.action" method="post" >
				<input type="hidden" name="currentPage" value="${currentPage}"> 
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改组织架构</h4>
					</div>
					<div class="modal-body">
						<fieldset>
							 <input type="hidden" id="orgID" name="orgInfo.id" value=""/>
							 <div class="form-group">
							 	 <label for="org_name" class="col-md-3 control-label"><font style="color:red">*</font>组织架构名：</label>
							 	 <div class="col-md-7">
	  								<input type="text" class="form-control col-md-3" id="orgName" name="orgInfo.orgName" required autofocus />
							 	 </div>
							 </div>
							<div class="form-group">
						<label for="orgDesc" class="col-md-2 control-label">架构描述：</label>
						<div class="col-md-8 textarea">
							<textarea class="text1" id="orgDesc" name="orgInfo.orgDesc"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="orgParentID" class="control-label col-md-2">上级:</label>
						<div class="col-md-5 ">
							<select id="e1" class="populate select2-offscreen " name="orgInfo.orgParentID" tabindex="-1">
							<s:if test="orgParentList == null||orgParentList.size<1">
								<option value=""/>无上级</option>
							</s:if>
							<s:else>
								<option value=""/>无上级</option>
								<s:iterator value="orgParentList" id="list" status="index">
									<option value="<s:property value="#list.id"/>"><s:property value="#list.orgFname" /></option>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.orgParentID" id="orgInfo.orgParentID"/>
						</div>
					</div>
					<div class="form-group">
						<label for="roleID" class="control-label col-md-2">角色:</label>
						<div class="col-md-5 ">
							<select id="erole" class="populate select2-offscreen " id="orgInfo.roleID" name="orgInfo.roleID" tabindex="-1" >
							<s:if test="roleList == null||roleList.size<1">
								<option value="" >无角色</option>
							</s:if>
							<s:else>
								<s:iterator value="roleList" id="rlist" status="index">
									<option value="<s:property value="#rlist.id"/>"><s:property value="#rlist.roleName" /></option>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.roleID" id="orgInfo.roleID"/>
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
					<h4 class="modal-title" id="myModalLabel">删除组织架构</h4>
				</div>
				<div class="modal-body">
					<h3>确认删除组织架构？</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="delOrg();">确认</button>
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