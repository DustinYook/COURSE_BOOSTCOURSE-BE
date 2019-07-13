<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- JSTL사용 위한 처리 -->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>방명록 목록</title>
	</head>
	<body>
		<c:if test="${sessionScope.isAdmin == 'true'}">
			<a href="logout">로그아웃</a><br><br>
		</c:if>
		<c:if test="${sessionScope.isAdmin != 'true'}">
			<a href="loginform">로그인</a><br><br>
		</c:if>
	
		<h1>방명록</h1><br> 
		방명록 전체 수 : ${count}, 현재 클라이언트가 방문한 수 : ${cookieCount} <br><br>

		<!-- list의 내용을 꺼내서 출력하는 코드 -->
		<c:forEach items="${list}" var="guestbook">
			${guestbook.id}<br>
			${guestbook.name}<br>
			${guestbook.content}<br>
			${guestbook.regdate}<br>
			<!-- 세션을 이용한 처리 -->
			<c:if test="${sessionScope.isAdmin == 'true'}">
				<a href="delete?id=${guestbook.id}">삭제</a><br><br>
				<!-- <a>태그는 GET방식으로 요청을 보냄 -->
			</c:if>
		</c:forEach><br>
		
		<!-- 페이지 링크 출력하기 위한 부분 -->
		<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
			<a href="list?start=${pageIndex}">${status.index+1}</a>&nbsp;&nbsp;
		</c:forEach><br><br>
	
		<!-- 방명록을 입력할 수 있는 부분 -->
		<form method="post" action="write">
			name : <input type="text" name="name"><br>
			<textarea name="content" cols="60" rows="6"></textarea><br>
			<input type="submit" value="등록">
		</form>
	</body>
</html>