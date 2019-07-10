<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored = "true" %> <!-- EL 비활성화 -->
<% 
	request.setAttribute("k", 10); 
	request.setAttribute("m", true);
%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	k :	${k}<br>
	k + 5 : ${k + 5}<br>
	k - 5 : ${k - 5}<br>
	k / 5 : ${k div 5}<br> <!-- '/'같은 경우 예약어 이용 -->
	k * 5 : ${k * 5}<br><br>
	
	k > 5 : ${k > 5}<br>
	k < 5 : ${k < 5}<br>
	k <= 10 : ${k <= 10}<br>
	k >= 10 : ${k >= 10}<br>
	k == 10 : ${k == 10}<br>
	k != 10 : ${k != 10}<br>
	m : ${m}<br>
	!m : ${!m}<br><br>
</body>
</html>