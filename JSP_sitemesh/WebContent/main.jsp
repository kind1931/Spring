<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- <jsp:include page="./header.jsp" /> 코드공유안함 같은버퍼에 담김--%>
<%-- <%@ include file="./header.jsp" %> 같이 모아서 컴파일 하기때문에 코드가 공유됨--%>

<title>main.jsp</title>
<head>
	<style>
		body{background:yellow;}
	</style>
</head>
<body>

	main.jsp<br/>
	header.jsp : message : ${message }<hr/>
</body>
<%-- <jsp:include page="./footer.jsp" /> --%>