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
<script type="text/javascript">
$(function() {
	
/* 	$("select.populate").each(function() { 
		var e=$(this); 
		var opts=e.html(), opts2="<option></option>"+opts;
		alert(opts+"/"+opts2);
		e.html(e.hasClass("placeholder")?opts2:opts); });*/
	}); 


$(document).ready(function() {
	$("#timeUnit").select2({ minimumResultsForSearch: -1 });
	$("#e1").select2({ minimumResultsForSearch: -1 });
}); 
</script>
<body>
<s:if test='createResult == "1"'>
<h4 class="form-signin-heading" style="color:red">创建任务成功！</h4>
</s:if>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">创建任务</h4>
		<form id="misForm" class="form-horizontal" action="${ctx}/mission/create.action" method="post" >
		
			<fieldset>
			<div class="form-group">
		         <label for="mission_name" class="col-md-2 control-label"><font style="color:red">*</font>任务名：</label>
	         	 <div class="col-md-8">
	         	 	<input type="text" class="form-control col-md-2" id="mission_name" name="missionInfo.missionName" required autofocus />
	         	 </div>
	        </div>
	        <div class="form-group">
		         <label for="mission_name" class="col-md-2 control-label">任务描述：</label>
	         	 <div class="col-md-8 textarea">
                 	<textarea class="text1" id="missionDesc" name="missionInfo.descr" ></textarea> 
	         	 </div>
	        </div>
		    <div class="form-group">
			<label for="plan_time" class="control-label col-md-2" >计划时长:</label>
			<div class="col-md-2"><input type="text" class="form-control" id="planTime" name="missionInfo.planTime"  /></div>
			
			<div class="col-md-2">
				<select id="timeUnit" name="missionInfo.timeUnit" class="populate select2-offscreen"  tabindex="-1">
					<option value="1">人天</option>
					<option value="2">人时</option>
				</select>
			</div>
			</div>
			<div class="form-group">
				<label for="missionLevel" class="control-label col-md-2">优先级:</label>
			<div class="col-md-2 ">
				<select id="e1" class="populate select2-offscreen " name="missionInfo.missionLevel"   tabindex="-1">
					<option value="1">重</option>
	              	<option value="2">缓</option>
				</select></div>
			</div>
		    <div class="form-group">
					<label for="startTime" class="control-label col-md-2">开始时间:</label>
					<div class="col-md-3">
						<div id="start_time" class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="start_time" data-link-format="yyyymmdd">
		                    <input class="form-control" id="missionInfo.startTime" name="missionInfo.startTime" type="text" value="" readonly>
							<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                		</div><br/>
					</div>
					<label for="end_time" class="control-label col-md-2">结束时间：</label>
					<div class="col-md-3">
						<div id="endTime"  class="input-group date form_date " data-date="" data-date-format="yyyy-mm-dd" data-link-field="end_time" data-link-format="yyyymmdd">
		                    <input class="form-control" type="text" value="" id="missionInfo.endTime"  name="missionInfo.endTime"  readonly>
							<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                		</div><br/>
					</div>
			</div>	  
			<div class="form-group">
				<label for="executor" class="control-label col-md-2" >经办人</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="executor" name="missionInfo.executor" value="(完成用户的角色以及权限后补充完整)"/>
				</div>
			</div>
			 <button type="submit" class="btn btn-default control-label">提交</button>
			 </fieldset>
		</form>
		</div>
	</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	$('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
</script>
	
</body>
</html>