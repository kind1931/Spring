<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
	tr.data{ cursor:pointer;}
</style>
</head>
<body>
<h1>회원리스트</h1>
<hr/>
<div class="row">
  <div class="col-md-1">
    <button type="button" onclick="insert_go()" class="btn btn-primary">회원등록</button> 
  </div>
  <!-- col-md-1 -->
  <select name="searchType" >
	<option value="">검색구분</option>
	<option value="i">아이디</option>
	<option value="n">이름</option>
	<option value="e">이메일</option>
  </select>
  <div class="col-md-3">
    <div class="input-group" >
      <input type="text" name="keyword" class="form-control"/>
      <span class="input-group-append">
      <button class="btn btn-warning">검색</button>
    </span>
    </div>
    <!-- input-group -->
  </div>
  	<!-- col-md-3 -->
</div>
<!-- row -->
<p></p>




<div class="col-sm-12">
<table class="table table-bordered table-hover" >
	<tr>
		<th class="sorting sorting_asc">아이디</th>
		<th class="sorting">이름</th>
		<th class="sorting">패스워드</th>
		<th class="sorting">주소</th>
		<th class="sorting">email</th>
		<th class="sorting">전화번호</th>
	</tr>
<%-- <% 
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList"); 
	for (MemberVO member : memberList){
	pageContext.setAttribute("member", member);
%> --%>
<c:if test="${not empty memberList }"><c:forEach items="${memberList }" var="member">
	<tr class="data" onclick="detail_go('${member.id}');">
		<%-- <td><%=member.getId() %></td> --%>
		<td>${member.id }</td>
		<td>${member.name }</td>
		<td>${member.pwd }</td>
		<td>${member.address }</td>
		<td>${member.email }</td>
		<td>${member.phone }</td>
	</tr>
</c:forEach></c:if>
<c:if test="${empty memberList }">
	<tr >
		<td colspan="6" style="text-align:center;">해당 내용이 없습니다.</td>
	</tr>
</c:if>
<%-- <%			
	} 
%> --%>
	

</table>
</div>
<!-- col-sm-12 -->
<script>

	function detail_go(member_id){
		//alert(member_id);
		window.open('detail.do?id='+member_id,'800','700','');
	}
	function insert_go() {
		location.href = "register.do";
	}
	
</script>
</body>
</html>






