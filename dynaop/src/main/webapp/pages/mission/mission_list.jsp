<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>任务</title>
<jsp:include page="../head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/bootstrap-paginator.min.js"></script>
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
				<th>任务名</th>
				<th>优先级</th>
				<th>计划时长</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>创建者</th>
			</tr>
		</thead>
		<tbody id="tbodyid" >
			<s:iterator value="missionList"  id="list">
			<tr>
				<td><s:property value="#list.missionName"/></td>
				<td><s:property value="#list.missionLevel"/></td>
				<td><s:property value="#list.planTime"/>
				<s:if test="#list.timeUnit=1">
				人天</s:if>
				<s:else>人时</s:else>
				</td>
				<td><s:property value="#list.startTime.substring(0,10)"/></td>
				<td><s:property value="#list.endTime.substring(0,10)"/></td>
				<td><s:property value="#list.creator"/></td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
<div style="align:center">
    <ul id='splitPage'></ul>
</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	
	var totalPages=$('#totalPages')[0].innerHTML ;
	var totalRecord=$('#totalRecord')[0].innerHTML ;
	var currentPage=$('#currentPage')[0].innerHTML;
	
	var element = $('#splitPage');
	
	var options = {
		bootstrapMajorVersion:3,
		alignment:'right',
	    currentPage: currentPage,
	    numberOfPages: 10,
	    totalPages:totalPages,
	    tooltipTitles: function (type, page, current) {
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
        shouldShowPage:function(type, page, current){
            switch(type)
            {
                default:
                    return true;
            }
        },
        pageUrl:function(type,page,current){
        	return "${ctx}/mission/misList.action?currentPage="+page;
        }
   
	};
	
	element.bootstrapPaginator(options);
});
</script>
</html>