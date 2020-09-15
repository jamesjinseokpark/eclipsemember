<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제여부 확인</title>
</head>
<script>
		function loadFunc() {

			var ok = confirm('진짜 삭제하시겠습니까?');
			if (ok == true) {

				document.getElementById('delete').submit();

			} else {
				alert('취소');
			}

		}

		window.onload = loadFunc
	</script>
<body>

	<form id='delete' action='delete' method='post'>
		<input type='text' name='no' value='<%=request.getParameter("no")%>'>
	</form>



</body>
</html>