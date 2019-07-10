package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/ten")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// 나는 응답을 이런 형식으로 보낼거야
		response.setContentType("text/html;charset=utf-8"); // 브라우저가 어떤 타입인지 파악가능, charset을 통해 parsing 정상적으로 할 수 있음
		
		// 응답을 할 수 있는 통로
		PrintWriter out = response.getWriter(); // printWriter 객체를 리턴 받음
		out.print("<h1>1에서 10까지 출력</h1>"); // println을 써도 줄 바꿈 안함 (반드시 <br> 필요)
		for(int i = 1; i <= 10; i++) // 서블릿은 자바문법 그대로
			out.print(i + "<br>"); // 줄 바꿈 위해서는 반드시 <br>을 넣어주어야 함
		out.close();
	}
}
