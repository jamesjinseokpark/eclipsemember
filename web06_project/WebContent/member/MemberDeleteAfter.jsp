<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String) request.getAttribute("name");

%>	  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Refresh' content='10;url=list'>
<meta charset="UTF-8">
<title>회원정보 수정결과</title>
<script> window.onload = function() {
	setTimeout(function(){
		window.location.href='list';
		}, 3000);	
};
</script>
</head>
<body>
	<p><%=name%>님 탈퇴완료!</p>
	<a href='list'>리스트로 돌아가기</a>
</body>
</html>