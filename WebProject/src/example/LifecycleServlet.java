package example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
1. 클라이언트가 URL을 통해 서버에 request 보냄 
2. 해당 URL에 mapping된 LifecycleServlet을 찾음 
3. 해당 서블릿의 인스턴스가 메모리에 존재하는지 확인
4. 메모리 X: 생성자 호출 (인스턴스를 생성), 메모리 O: service 메서드를 호출
- 브라우저 새로 고침 = 새로운 request 보냄 : 따라서 생성자 호출 없이 service 메서드만 호출
- 서블릿 코드를 수정하면 기존 인스턴스를 destroy한 후 새롭게 인스턴스를 생성
- 서블릿은 서버에 인스턴스를 여러 개 만들지 않음 : 요청된 서블릿 인스턴스가 존재하는지 먼저 체크함
*/

@WebServlet("/LifecycleServlet") // 1) 해당 URL로 클라이언트가 서버에 요청
public class LifecycleServlet extends HttpServlet  // 2) 해당 URL에 mapping된 서블릿을 찾음
{
	private static final long serialVersionUID = 1L;
    
	// 3) 해당 서블릿 인스턴스가 메모리에 존재하는지 확인
    public LifecycleServlet() // 존재하지 않으면 메모리에 인스턴스 생성
    {
    	System.out.println("LifecycleServlet 생성!"); // System.out은 콘솔에 출력하는 것이지 응답으로 보내는 것은 아님
    }
    
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init 호출!"); 
	}

	public void destroy() 
	{
		System.out.println("destroy 호출!");
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		System.out.println("service 호출!");
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstWeb/LifecycleServlet'>");
		// form 태그 - method는 요청방식, action은 request를 보낼 URL mapping
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name"); // request로부터 파라미터가 name으로 지정된 것을 받아옴
		// request는 요청정보를 추상화시켜 가지고 있는 객체
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}
}