// LogicServlet에서 1부터 100사이의 random한 값 2개와 그 값의 합을 구한 후, 그 결과를 result.jsp에게 포워딩하는 방법으로 전송하여 결과를 출력
package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1단계 : 결과생성
		int v1 = (int)(Math.random() * 100) + 1;
		int v2 = (int)(Math.random() * 100) + 1;
		int result = v1 + v2; 
		// 2단계 : request에 맡김
		request.setAttribute("result", result);
		request.setAttribute("v1", v1);
		request.setAttribute("v2", v2);
		// 3단계 : forward
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/class02/result.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
