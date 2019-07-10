package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // response의 content type
		PrintWriter out = response.getWriter(); // 클라이언트와의 연결통로 열어줌
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		/** 핵심코드 */
		String name = request.getParameter("name"); 
		// getParameter를 통해서 가져옴 - 인자로 key를 받고 value를 리턴함
		// { key : value } -> 다 문자열로 넘어옴
 		String age = request.getParameter("age");
		
 		// 동적으로 응답결과가 생성! - URL의 파라미터에 따라 넘어옴
		out.println("name : " + name + "<br>"); 
		out.println("age : " +age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
