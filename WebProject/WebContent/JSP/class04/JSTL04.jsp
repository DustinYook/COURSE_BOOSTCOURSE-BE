<!-- import를 위한 페이지 지시자 -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 사용하기 위한 지시자 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	List<String> list = new ArrayList<String>();
	list.add("hello");
	list.add("world");
	list.add("!!!");
	
	request.setAttribute("list", list); // request scope에 맡김
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${requestScope.list}" var="item" begin="1">
		${item}<br>
	</c:forEach>
</body>
</html>