<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../common.jsp"></jsp:include>
	<div class="modal-content col-md-7 col-md-offset-2">
		<form id="PerForm" class="form-horizontal" action="${ctx}/role/modstore.action" method="post" >
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="rid" value="${storeMap.roleID}">  
			<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改角色库</h4>
					</div>
			<fieldset>
			<div class="modal-body" >
					<div class="form-group">
						<label for="roleName" class="col-md-3 control-label"><font style="color: red">*</font>角色名：</label>
						<div class="col-md-5">
							<input type="text" class="form-control col-md-2" id="storeMap.roleName" name="storeMap.roleName" value='<s:property value="storeMap.roleName"/>' required autofocus />
						</div>
					</div>
					<div class="form-group">
						<label for="perIDS" class="control-label col-md-3">权限:</label>
						<div class="col-md-5 ">
							<select id="eper" multiple="multiple" class="multiSelect populate select2-offscreen" style="width:100%" name="storeMap.perIDS" >
								<%-- <s:if test="perList == null||perList.size<1">
								<option value="" >无权限</option>
							</s:if>
							<s:else> --%>
								<s:iterator value="perList" id="rlist" status="index">
										<option value='<s:property value="#rlist.id" />'><s:property value="#rlist.perName" /></option>
								</s:iterator>
							<%-- </s:else> --%>
							</select>
						</div>
					</div>
					</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" >确认</button>
					</div>
			 </fieldset>
		</form>
	</div>
<script type="text/javascript">
$(function() {
	
$(document).ready(function() {
	$("#eper").select2();
	var str = '${storeMap.perIDS}';
	if(str!=null&&str!=""){
	alert(str);
		var strArray = new Array();
		strArray = str.split(",");
		var datas = '[';
		$.each(strArray,function(index,tx){
			tx = $.trim(tx);
			 if(index == strArray.length-1){
				datas=datas+'"'+tx+'"]';
			}else{
				datas=datas+'"'+tx+'",';
			} 
			});
		var obj = jQuery.parseJSON(datas);
		$("#eper").select2("val",obj);
	}
}); 
});
</script>
