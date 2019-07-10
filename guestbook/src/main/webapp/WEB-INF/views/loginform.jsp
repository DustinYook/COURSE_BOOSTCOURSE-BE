<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자 로그인</title>
	</head>
	<body>
		<h1>관리자 로그인</h1><br>
		${errorMessage}<br> <!-- 로그인 실패 시 flash map에서 꺼내서 보여줌 -->

		<!-- 역할 : 패스워드를 입력받고 submit을 누르면 '/login'으로 post요청을 보냄  -->
		<form method="post" action="login">
			패스워드 : <input type="password" name="passwd"><br>
			<input type="submit" value="login">
		</form>
	</body>
</html>