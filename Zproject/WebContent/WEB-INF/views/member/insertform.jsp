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
<h1>회원등록</h1>
<hr/>
<form action="register.do" method="post">
<table>
	<tr>
		<th>아이디</th>
		<th><input name="id" type="text" required="required"
		 placeholder="영문,숫자 조합  7~15자리" pattern="^[a-z]+[a-z0-9]{6,14}$"></th>
	</tr>
	<tr>
		<th>이름</th>
		<th><input name="name"  type="text" required="required"
		placeholder="한글 2~6자리 입력" pattern="^[가-힣]{2,6}$"></th>
	</tr>
	<tr>
		<th>패스워드</th>
		<th><input name="pwd"  type="password" required="required"
		placeholder=""></th>
	</tr>
	<tr>
		<th>주소</th>
		<th><input name="address" type="text" required="required"
		placeholder=""></th>
	</tr>
	<tr>
		<th>email</th>
		<th><input name="email"  type="email" required="required"
		placeholder=""></th>
	</tr>
	<tr>
		<th>전화번호</th>
		<th><input name="phone"  type="tel" required="required"
		placeholder="000-0000-0000" pattern=^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$></th>
	</tr>
	<tr>
		<td colspan="2">
		<span "row">
		<button type="submit" value="등록" class="btn btn-primary">등록</button> &nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="goList()" class="btn btn-secondary">취소</button>
		</span>
		</td>
	</tr>
</table>
</form>
<script>
function goList() {
	location.href='list.do';
}
</script>
</body>
</html>