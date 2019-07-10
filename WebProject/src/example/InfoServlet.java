package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); // 응답결과의 포멧을 알려줌
		PrintWriter out = response.getWriter(); // 클라이언트와의 연결 통로를 생성함
		
		out.println("<html>");
		out.println("<head><title>info</title></head>");
		out.println("<body>");

		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String contentPath = request.getContextPath();
		String remoteAddr = request.getRemoteAddr();
		
		out.println(request.getCookies() + "<br>");
		out.println("uri : " + uri + "<br>"); // URL에서 포트번호 이하 출력
		out.println("url : " + url + "<br>"); // URL
		out.println("contentPath : " + contentPath + "<br>"); // 
		out.println("remoteAddr : " + remoteAddr + "<br>"); // 클라이언트의 IP 주소
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}