<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello~
	<%
		/** JSP의 실행순서
		1. 브라우저가 웹서버에 JSP에 대한 요청 정보를 전달한다.
		2. 브라우저가 요청한 JSP가 최초로 요청했을 경우만 JSP로 작성된 코드가 서블릿으로 코드로 변환한다. (java 파일 생성)
		3. 서블릿 코드를 컴파일해서 실행가능한 bytecode로 변환한다. (class 파일 생성)
		4. 서블릿 클래스를 로딩하고 인스턴스를 생성한다.
		5. 서블릿이 실행되어 요청을 처리하고 응답 정보를 생성한다. */
		System.out.print("jspService()");
	%>
	
	<%!
		public void jspInit()
		{
			System.out.println("jspInit()!");
		}
	
		public void jspDestroy()
		{
			System.out.println("jspDestroy()");
		}
	%>
</body>
</html>