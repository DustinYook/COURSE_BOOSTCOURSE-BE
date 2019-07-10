package forward;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int diceValue = (int)(Math.random() * 6) + 1; // front servlet의 결과
		// request에 맡겨 NextServlet에서 사용할 수 있게 함
		request.setAttribute("dice", diceValue);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next"); // 인자는 어디로 이동할지
		// 같은 어플리케이션 내부에서만 가능
		requestDispatcher.forward(request, response);
		
		// FrontServlet에서는 난수 생성 -> NextServlet으로 forward
		// NextServlet에서 값 받고 처리하여 response
	}

}
