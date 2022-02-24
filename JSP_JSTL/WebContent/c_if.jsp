<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String str = "abc"; %>

<c:set var="str" value="<%=str %>" />
<!-- scope 속성 지정 안하면 page -->
<!-- var 속성(변수선언)이 있으면 결과값을 그 변수에 할당한다는 말 -->
<c:if test="${str eq 'abc' }" var="result" scope="request" >
	${str }
</c:if>

:::: ${result}