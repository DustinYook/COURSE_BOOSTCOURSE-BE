package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextServlet
 */
@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter(); // 응답통로
	        
	        out.println("<html>");
	        out.println("<head><title>form</title></head>");
	        out.println("<body>");

	        int dice = (Integer)request.getAttribute("dice"); // 맡긴 정보 찾아옴
	        out.println("dice : " + dice);
	        
	        for(int i = 0; i < dice; i++) 
	            out.print("<br>hello");
	        
	        out.println("</body>");
	        out.println("</html>");
	}

}
