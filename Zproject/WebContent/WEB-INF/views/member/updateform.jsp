<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>회원수정</h1>
<hr/>
<form action="modify.do" method="post">
<table>
	<tr>
		<th>아이디</th>
		<th>${member.id }<input name="id" type="hidden" value="${member.id }" /></th>
	</tr>
	<tr>
		<th>이름</th>
		<th><input name="name"  type="text" value="${member.name }"></th>
	</tr>
	<tr>
		<th>패스워드</th>
		<th><input name="pwd"  type="password" value="${member.pwd }"></th>
	</tr>
	<tr>
		<th>주소</th>
		<th><input name="address" type="text" value="${member.address }"></th>
	</tr>
	<tr>
		<th>email</th>
		<th><input name="email"  type="email" value="${member.email }"></th>
	</tr>
	<tr>
		<th>전화번호</th>
		<th><input name="phone"  type="tel" value="${member.phone }"></th>
	</tr>
	<tr>
		<td colspan="2">
		<button type="submit" class="btn btn-primary">저장</button>&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="goback()" class="btn btn-secondary">취소</button>
		</td>
	</tr>
</table>
</form>
<script>
function goback(){
	location.href='detail.do?id=${member.id }';
}
</script>
</body>
</html>