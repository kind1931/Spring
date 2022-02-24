<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="pageContext" scope="page" />
<c:set var="msg" value="request" scope="request" />
<c:set var="msg" value="session" scope="session" />
<c:set var="msg" value="application" scope="application" />

<c:remove var="msg" scope="request" />

<ul>
	<li>pageContext : ${pageScope.msg } </li>
	<li>request : ${requstScope.msg } </li>
	<li>session : ${sessionScope.msg } </li>
	<li>application : ${applicationScope.msg } </li>
</ul>