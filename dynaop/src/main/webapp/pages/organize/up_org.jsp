<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div class="modal-content col-md-7 col-md-offset-2">
		<form id="roleForm" class="form-horizontal" action="${ctx}/organize/modorg.action" method="post" >
			<input type="hidden" name="currentPage" value="${currentPage}"> 
			<input type="hidden" name="orgInfo.id" value="${orgInfo.id}"> 
			<input type="hidden" name="orgInfo.relID" value="${orgInfo.relID}"> 
			<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改组织架构</h4>
					</div>
			<fieldset>
			<div class="modal-body" >
					<div class="form-group">
						<label for="orgFname" class="col-md-3 control-label"><font style="color: red">*</font>架构名：</label>
						<div class="col-md-5">
							<input type="text" class="form-control col-md-2" id="orgFname" name="orgInfo.orgFname" value='<s:property value="orgInfo.orgFname"/>' required autofocus />
						</div>
					</div>
					<div class="form-group">
						<label for="orgDesc" class="col-md-3 control-label">架构描述：</label>
						<div class="col-md-5 textarea">
							<textarea class="text1" id="orgDesc" name="orgInfo.orgDesc" ><s:property value="orgInfo.orgDesc"/></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="orgParentID" class="control-label col-md-3">上级:</label>
						<div class="col-md-5 ">
							<select id="e1" class="populate select2-offscreen" style="width:100%" name="orgInfo.orgParentID" tabindex="-1">
							<s:if test="orgParentList == null||orgParentList.size<1">
								<option value="" >无上级</option>
							</s:if>
							<s:else>
								<option value="" >无上级</option>
								<s:iterator value="orgParentList" id="list" status="index">
								<s:if test="#list.id == orgInfo.orgParentID">
									<option value="<s:property value="#list.id"/>" selected><s:property value="#list.orgFname" /></option>
								</s:if>
								<s:else>
									<option value="<s:property value="#list.id"/>" ><s:property value="#list.orgFname" /></option>
								</s:else>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.orgParentID" id="orgInfo.orgParentID"/>
						</div>
					</div>
					<div class="form-group">
						<label for="roleID" class="control-label col-md-3">角色:</label>
						<div class="col-md-5 ">
							<select id="erole" class="populate select2-offscreen" style="width:100%"  id="orgInfo.roleID" name="orgInfo.roleID" tabindex="-1" >
							<s:if test="roleList == null||roleList.size<1">
								<option value="" >无角色</option>
							</s:if>
							<s:else>
								<option value="" >无角色</option>
								<s:iterator value="roleList" id="rlist" status="index">
									<s:if test="#rlist.id == orgInfo.roleID">
										<option value="<s:property value="#rlist.id"/>" selected><s:property value="#rlist.roleName" /></option>
									</s:if>
									<s:else>
										<option value="<s:property value="#rlist.id"/>"><s:property value="#rlist.roleName" /></option>
									</s:else>
								</s:iterator>
							</s:else>
							</select>
							<input type="hidden" name="orgInfo.roleID" id="orgInfo.roleID"/>
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
$(document).ready(function() {
	$("#e1").select2({ minimumResultsForSearch: -1 });
	$("#erole").select2({ minimumResultsForSearch: -1 });
}); 
</script>
