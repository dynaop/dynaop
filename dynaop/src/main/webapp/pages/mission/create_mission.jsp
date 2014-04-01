<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>创建任务</title>
<jsp:include page="../head.jsp"></jsp:include>
<link href="${ctx}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/css/select2-3.4.5.css" rel="stylesheet" >
<link href="${ctx}/css/use_0226.css" rel="stylesheet" >
</head>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/select2-3.4.5.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap3-validation.js" charset="UTF-8"></script>

<script type="text/javascript">
$(function(){
$("#misForm").validation();
$("#sub").on('click',function(event){
    if ($("#misForm").valid()==false){
      $("#error-text").text("填写信息不完整。");
      return false;
      }
  });
});

$(document).ready(function() {
	$('#timeUnit').select2({ minimumResultsForSearch: -1 });
	$('#priority').select2();
	$('#executor').select2();
	$('#misParent').select2();
}); 


</script>
<body>
<s:if test='createResult == "1"'>
<h4 class="form-signin-heading" style="color:red">创建任务成功！</h4>
</s:if>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">创建任务</h4>
		<form id="misForm" class="form-horizontal"  action="${ctx}/mission/create.action" method="post" >
		
			<fieldset>
			<div class="form-group">
		         <label for="mission_name" class="col-md-2 control-label"><font style="color:red">*</font>任务名：</label>
	         	 <div class="col-md-8">
	         	 	<input type="text" class="form-control col-md-2" id="mission_name" name="missionInfo.missionName" check-type="required"  autofocus />
	         	 </div>
	        </div>
	        <div class="form-group">
		         <label for="mission_name" class="col-md-2 control-label">任务描述：</label>
	         	 <div class="col-md-8 textarea">
                 	<textarea class="text1" id="missionDesc" name="missionInfo.descr" ></textarea> 
	         	 </div>
	        </div>
	        
	        <div class="form-group">
		         <label for="mission_parent" class="col-md-2 control-label">父任务：</label>
	         	 <div class="col-md-5">
                 	<select id="misParent" class="populate select2-offscreen "  style="width:56%"  name="missionInfo.misParent"   >
                 		<option value='0'>根任务</option>
					<s:iterator value="misspList" id="list" status="index">
						<option value='<s:property value="#list.id"/>'><s:property value="#list.mission_name"/></option>
					</s:iterator>
				</select>
	         	 </div>
	        </div>

					<div class="form-group">
						<label for="plan_time" class="control-label col-md-2">计划时长:</label>
						<div class="col-md-3">
							<div id="pt">
								<input type="text" class="form-control" id="planTime" check-type="required number" name="missionInfo.planTime" />
							</div>
							<br />
						</div>
						<div class="col-md-3">
							<div id="tu">
								<select id="timeUnit" name="missionInfo.timeUnit"  style="width:45%"  class="populate select2-offscreen" tabindex="-1">
									<option value="1">人天</option>
									<option value="2">人时</option>
								</select>
							</div>
							<br />
						</div>
					</div>
			<div class="form-group">
				<label for="missionLevel" class="control-label col-md-2">优先级:</label>
			<div class="col-md-3">
				<select id="priority" class="populate select2-offscreen "  style="width:100%"  name="missionInfo.missPriority" >
					<s:iterator value="priList" id="plist">
						<option value='<s:property value="#plist.id"/>'><s:property value="#plist.priName"/></option>
					</s:iterator>
				</select></div>
			</div>
		    <div class="form-group">
					<label for="startTime" class="control-label col-md-2">开始时间:</label>
					<div class="col-md-3">
						<div id="start_time" >
		                    <input class="form-control form_date" id="startDate" check-type="date required" name="missionInfo.startTime" type="date" value="" >
                		</div><br/>
					</div>
					<label for="end_time" class="control-label col-md-2">结束时间：</label>
					<div class="col-md-3">
						<div id="endTime" >
		                    <input class="form-control form_date" id="endDate" check-type="date start-end-date"    name="missionInfo.endTime"   type="date" value="">
                		</div><br/>
					</div>
			</div>	  
			<div class="form-group">
				<label for="executor" class="control-label col-md-2" >经办人角色:</label>
				<div class="col-md-5">
				<select id="executor" class="populate select2-offscreen "  style="width:56%" name="missionInfo.executor"   >
				<s:iterator value="roleList" id="list" status="index">
					<option value='<s:property value="#list.id"/>'><s:property value="#list.roleName"/></option>
				</s:iterator>
				</select>
				</div>
			</div>
			 <div class="form-group">
			 <div class="col-md-2">
			 	<button type="submit" id="sub" class="btn btn-default control-label">提交</button>
			 </div>
		        <div class="col-md-5">
		          <span id="error-text" style="color: #FF0000;"></span>
		        </div>
		      </div>
			 </fieldset>
		</form>
		</div>
	</div>
<script type="text/javascript">
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		format: 'yyyy-mm-dd',
		forceParse: 0
    });
</script>
	
</body>
</html>