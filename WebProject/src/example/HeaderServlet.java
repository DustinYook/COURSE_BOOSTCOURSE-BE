package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public HeaderServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); // 응답을 보내기 전에 content type이 뭔지 알려줌
		PrintWriter out = response.getWriter(); // 클라이언트와의 연결통로 생성
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		// getHeaderNames(): 모든 헤더이름을 문자열 Enumeration 객체형태로 반환
		Enumeration<String> headerNames = request.getHeaderNames(); 
		while(headerNames.hasMoreElements()) 
		{
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println(headerName + " : " + headerValue + " <br> "); // 응답결과에 넣기 위해 out을 사용
		}		
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
