package scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope01
 */
@WebServlet("/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 응답 포멧
		
		PrintWriter out = response.getWriter();	// 응답 내보낼 통로 얻어냄
		ServletContext application = getServletContext(); // 전체 웹 어플리케이션의 ServletContext 객체 얻어낼 수 있음
		
		int value = 1;
		application.setAttribute("value", value); // application scope에 값을 맡김
		
		out.println("<h1>value : " + value + "</h1>");
	}
}
