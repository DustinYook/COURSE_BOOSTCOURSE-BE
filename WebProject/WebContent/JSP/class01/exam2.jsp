<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp 주석입니다! 
	여러 줄로 사용가능합니다 --%>
	<!-- html 주석입니다 -->
	<% // 여기는 자바주석입니다.
	/* 여러 줄로 사용가능합니다 */
	for(int i = 1; i <= 6; i++) { %>
		<h<%=i%>>아름다운 한글</h<%=i%>>
	<% } %>
</body>
</html>