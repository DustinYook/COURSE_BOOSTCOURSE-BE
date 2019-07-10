<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("p1", "page scope value"); // page scope에 맡김
	request.setAttribute("r1", "request scope value"); // request scope에 맡김
	session.setAttribute("s1", "session sccope value"); // session scope에 맡김
	application.setAttribute("a1", "application scope value"); // application scope에 맡김
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- page scope -->
	pageContext.getAttribute("p1") : <%= pageContext.getAttribute("p1") %><br>
	pageContext.getAttribute("p1") : ${pageScope.p1}<br><br>
	<!-- request scope -->
	request.getAttribute("r1") : <%= request.getAttribute("r1") %><br>
	request.getAttribute("r1") : ${requestScope.r1}<br><br>
	<!-- session scope -->
	session.getAttribute("s1") : <%= session.getAttribute("s1") %><br>
	session.getAttribute("s1") : ${sessionScope.s1}<br><br>
	<!-- application scope -->
	application.getAttribute("a1") : <%= application.getAttribute("a1") %><br>
	application.getAttribute("a1") : ${applicationScope.a1}<br><br>
</body>
</html>