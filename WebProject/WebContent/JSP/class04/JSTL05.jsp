<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 사용하기 위한 지시자 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- import를 이용해서 url의 html페이지를 통채로 복사해서 값을 가져옴 -->
<c:import url="http://localhost:8080/WebProject/JSP/class04/JSTL_Value.jsp" var="urlValue" scope="request"></c:import>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${urlValue}
</body>
</html>