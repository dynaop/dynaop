<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../common.jsp"></jsp:include>
	<div class="modal-content col-md-7 col-md-offset-2">
		<form id="PriForm" class="form-horizontal" action="${ctx}/mission/modpri.action" method="post" >
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="rid" value="${priInfo.id}">  
			<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabelmod">修改任务优先级</h4>
					</div>
			<fieldset>
			<div class="modal-body" >
					<div class="form-group">
						<label for="priName" class="col-md-3 control-label"><font style="color: red">*</font>优先级名称：</label>
						<div class="col-md-5">
							<input type="text" class="form-control col-md-2" id="priName" name="priInfo.priName" value='<s:property value="priInfo.priName"/>' required autofocus />
						</div>
					</div>
					<div class="form-group">
						<label for="priDesc" class="col-md-3 control-label">优先级描述：</label>
						<div class="col-md-5 textarea">
							<textarea class="text1" id="priDesc" name="priInfo.priDesc" ><s:property value="priInfo.priDesc"/></textarea>
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
