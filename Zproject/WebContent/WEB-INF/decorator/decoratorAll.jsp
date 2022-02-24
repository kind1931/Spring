<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="새창"/> </title>
<%@ include file="/import.jsp" %>
<decorator:head />
</head>
<body>
<%@ include file="/headerW.jsp" %>

<div  style="padding-left: 30px;">
	<decorator:body />
</div>

<%@ include file="/footer.jsp" %>
</body>
</html>