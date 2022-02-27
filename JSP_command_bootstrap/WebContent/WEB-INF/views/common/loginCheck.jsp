<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert('로그인은 필수입니다.');
	if(window.opener){	//브라우저가 연 창이면
		window.close(); //새창만 먹힘. 브라우저가 연 녀석만 닫을 권리가 있음.
		window.opener.parent.location.href="<%=request.getContextPath()%>/";
	}else{
		window.parent.location.href="<%=request.getContextPath()%>/";
		//부모가 없으면 최상의 객체인 자기자신 =window.location
	}
</script>
