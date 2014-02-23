<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>创建任务</title>
<jsp:include page="../head.jsp"></jsp:include>
</head>
<script type="text/javascript">

</script>
<body>

	<div class="container">
		<div class="col-md-offset-1 ">
			<h4 class="form-signin-heading">创建任务</h4>
		<form class="form-horizontal" action="${ctx}/mission/create.action" method="post">
		
			<fieldset>
			<div class="form-group">
		         <label for="mission_name" class="col-md-2 control-label"><font style="color:red">*</font>任务名：</label>
	         	 <input type="text" class="form-control col-md-2" id="mission_name" name="missionInfo.mission_name" required autofocus />
	        </div>
		    <div class="form-group">
			<label for="plan_time" class="control-label col-md-2" >计划时长:</label>
			<div class="col-md-1"><input type="text" class="form-control" id="plan_time" name="missionInfo.plan_time"  /></div>
			
			<div class="col-md-2">
				<select id="time_unit" name="missionInfo.time_unit" class="selectpicker form-control " >
					<option value="1">人天</option>
					<option value="2">人时</option>
				</select>
			</div>
				<label for="mission_level" class="control-label col-md-2">优先级:</label>
			<div class="col-md-2">
			<select id="mission_level" name="missionInfo.mission_level" class="selectpicker form-control">
              <option value="1">重</option>
              <option value="2">缓</option>
            </select>
			</div></div>
		    <div class="form-group">
					<label for="start_time" class="control-label col-md-2">开始时间:</label>
					<div class="col-md-3">
						<div class="input-group date">
						  <input type="text" class="form-control" id="start_time" name="missionInfo.start_time"><div class="input-group-addon">
						  <i class="glyphicon glyphicon-th"></i></div>
						</div>
					</div>
					<label for="end_time" class="control-label col-md-2">结束时间：</label>
					<div class="col-md-3">
						<div class="input-group date">
						  <input type="text" class="form-control" id="end_time" name="missionInfo.end_time"><div class="input-group-addon">
						  <i class="glyphicon glyphicon-th"></i></div>
						</div>
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
</body>
</html>