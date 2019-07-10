<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL을 사용하기 위한 지시자 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="t" value="<script type='text/javascript'>alert(1);</script>"/>
	<!-- ${t}  -->
	<!-- <c:out value="${t}" escapeXml="true"/> <!-- javascript 코드를 문자자체로 인식 -->
	<c:out value="${t}" escapeXml="false"/> <!-- javascript 코드를 태그로 인식 -->
</body>
</html>