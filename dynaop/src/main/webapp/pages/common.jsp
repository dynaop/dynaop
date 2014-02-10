<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<%-- 页面全局变量：应用上下文路径 --%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
%>
<script type="text/javascript">
//脚本全局变量：应用上下文路径
var g_ctx = "${ctx}";
</script>