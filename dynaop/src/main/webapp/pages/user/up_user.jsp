<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../common.jsp"></jsp:include>
	<div class="modal-content col-md-7 col-md-offset-2">
		<form id="PerForm" class="form-horizontal" action="${ctx}/userinfo/moduser.action" method="post" >
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="rid" value="${userInfo.id}">  
			<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改用户</h4>
					</div>
			<fieldset>
			<div class="modal-body" >
					<div class="form-group">
						<label for="userame" class="col-md-3 control-label"><font style="color: red">*</font>用户名：</label>
						<div class="col-md-5">
							<label for="userame" class="col-md-3 control-label"><s:property value="userInfo.username"/></label>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">e-mail：</label>
						<div class="col-md-5">
							<input type="text" class="form-control col-md-2" id="email" name="userInfo.email" value='<s:property value="userInfo.email"/>' />
						</div>
					</div>
					<div class="form-group">
						<label for="menuIDS" class="control-label col-md-3">qq:</label>
						<div class="col-md-5 ">
							<input type="text" class="form-control col-md-2" id="qq" name="userInfo.qq" value='<s:property value="userInfo.qq"/>' />
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