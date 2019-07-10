<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 사용하기 위한 지시자 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 아래 두 코드는 동등한 표현식이다 -->
<%-- <% request.setAttribute("n", 10); --%>
<c:set var="n" scope="request" value="10"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 조건 맞지 않으면 실행되지 않음 -->
	<c:if test="${n == 0}">
		n과 0은 같습니다.
	</c:if>
	
	<c:if test="${n == 10}">
		n과 10은 같습니다.
	</c:if>
</body>
</html>