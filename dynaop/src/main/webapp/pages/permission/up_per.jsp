<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../common.jsp"></jsp:include>
	<div class="modal-content col-md-7 col-md-offset-2">
		<form id="PerForm" class="form-horizontal" action="${ctx}/permission/modper.action" method="post" >
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="rid" value="${perInfo.id}">  
			<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改权限</h4>
					</div>
			<fieldset>
			<div class="modal-body" >
					<div class="form-group">
						<label for="perName" class="col-md-3 control-label"><font style="color: red">*</font>权限名：</label>
						<div class="col-md-5">
							<input type="text" class="form-control col-md-2" id="perName" name="perInfo.perName" value='<s:property value="perInfo.perName"/>' required autofocus />
						</div>
					</div>
					<div class="form-group">
						<label for="perDesc" class="col-md-3 control-label">权限描述：</label>
						<div class="col-md-5 textarea">
							<textarea class="text1" id="perDesc" name="perInfo.perDesc" ><s:property value="perInfo.perDesc"/></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="menuIDS" class="control-label col-md-3">菜单:</label>
						<div class="col-md-5 ">
							<select id="emenu" multiple="multiple" class="multiSelect populate select2-offscreen" style="width:100%" name="perInfo.menuIDS" >
								<s:if test="menuList == null||menuList.size<1">
								<option value="" >无菜单</option>
							</s:if>
							<s:else>
								<s:iterator value="menuList" id="rlist" status="index">
									<s:if test='#rlist.parent_id == null || #rlist.parent_id == ""'>
										<optgroup label='<s:property value="#rlist.menu_name_zh" />'><s:property value="#rlist.menu_name_zh" />
									</s:if>
									<s:else>
										<option value="<s:property value="#rlist.menu_id"/>"><s:property value="#rlist.menu_name_zh" /></option>
									</s:else>
								</s:iterator>
							</s:else>
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
	$("#emenu").select2();
	var str = '${perInfo.menuIDS}';
	if(str!=null&&str!=""){
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
		$("#emenu").select2("val",obj);
	}
}); 
});
</script>
