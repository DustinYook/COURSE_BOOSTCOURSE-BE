<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- JSTL사용 위한 처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 맞추기 게임</title>
</head>
<body>
	<h1>숫자 맞추기 게임</h1>
	<hr>
	<h3>${message}</h3> <!-- 메세지 표시 -->
	
	<!-- 조건 만족시켰을 때만 보여줌 : 정답 맞췄을 때만 보여줌-->
	<c:if test="${sessionScope.count != null}"> <!-- 없는 것을 꺼내오면 null을 리턴 -->
		<form method="get" action="guess">
			1부터 100사이의 숫자를 맞춰주세요.<br>
			<input type="text" name="number"><br>
			<input type="submit" value="확인">
		</form>
	</c:if>
	
	<a href="guess">게임 다시 시작하기</a>
</body>
</html>