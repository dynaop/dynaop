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
</head>
<body>
	<table class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>任务名</th>
				<th>优先级</th>
				<th>计划时长</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>创建者</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="missionList"  id="list">
			<tr>
				<td><s:property value="#list.mission_name"/></td>
				<td><s:property value="#list.mission_level"/></td>
				<td><s:property value="#list.plan_time"/>
				<s:if test="#list.time_unit=1">
				人天</s:if>
				<s:else>人时</s:else>
				</td>
				<td><s:property value="#list.start_time.substring(0,10)"/></td>
				<td><s:property value="#list.end_time.substring(0,10)"/></td>
				<td><s:property value="#list.creator"/></td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
<div>
    <ul id='splitPage'></ul>
</div>
</body>

<script type="text/javascript">
	var element = $('#splitPage');
	
	var options = {
	    bootstrapMajorVersion:3,
	    currentPage: 1,
	    numberOfPages: 10,
	    totalPages:1
	}
	
	element.bootstrapPaginator(options);

</script>
</html>