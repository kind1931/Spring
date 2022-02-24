<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
	if('${target}') {
		location.replace('${target}');
	} else {
		location.replace('');
	}
		alert('${msg}');
	if('${target}') {
		location.href('${target}');
	} else {
		window.close();
		opener.parent.location.reload();
	}
</script>
</head>
<body>

</body>
</html>