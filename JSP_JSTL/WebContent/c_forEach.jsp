<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int sum=0;
	for(int i=1; i<11; i++){
		sum+=i;
	}
	out.println("out.println(sum) : "+sum+"<br/>");
%>

<%-- <% pageContext.setAttribute("sum", 0); %> --%>
<c:set scope="page" var="sum" value="0" />
<!-- 이치상 for문은 페이지 내부에서만 영향을 주므로 기본속성이scope="page"이다. -->
<c:forEach begin="1" end="10" step="1" var="i" >
	<c:set var="sum" value="${sum+i}" />
</c:forEach>
<!-- 1단계:가장 원초적인 방법 -->
out.println(pageContext.getAttribute("sum")) : <% out.println(pageContext.getAttribute("sum")); %>	<br/>
<!-- 2단계:1단계에서 out.println을 지우는 단계 -->
pageContext.getAttribute("sum") : <%=pageContext.getAttribute("sum") %>	<br/>
<%-- 최종단계 : <% %>자체를 지워 -> el문으로 변경--%>
＄{sum } :${sum }

</hr>
<%
	List<String> strList = new ArrayList<String>();
	strList.add(new String("a"));
	strList.add("b");
	
	if(strList!=null) for(String str : strList){
		out.println(str+"<br/>");
	}
%>

<c:set var="strList" value="<%=strList%>"/>
<c:forEach items="${strList }" var="str" >
	${str }<br/>
</c:forEach>
