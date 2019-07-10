<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 입력을 두 개 받아들임 -->
	<form method="post" action="plus"> <!-- '/plus'라는 URL로 POST방식으로 요청을 보냄 (action에 URL지정)  -->
		value1 : <input type="text" name="value1"><br>
		value2 : <input type="text" name="value2"><br> 
		<input type="submit" value="확인">
	</form>
</body>
</html>