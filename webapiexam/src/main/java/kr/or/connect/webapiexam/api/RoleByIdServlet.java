package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

/** Servlet implementation class RoleByIdServlet */
@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /** @see HttpServlet#HttpServlet() */
    public RoleByIdServlet() { super(); }

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("utf-8"); // 응답결과 인코딩 설정
		response.setContentType("application/json"); // JSON을 이용

		String pathInfo = request.getPathInfo(); // Path정보를 읽어옴 : /roles/{roleId} 
		String[] pathParts = pathInfo.split("/"); // 슬래시 기준으로 파싱
		String idStr = pathParts[1]; // roleId에 해당하는 값
		int id = Integer.parseInt(idStr); // int값으로 바꿔줌

		RoleDao dao = new RoleDao(); // DAO 객체 생성
		Role role = dao.getRole(id); // id에 해당하는 튜플 읽어옴

		ObjectMapper objectMapper = new ObjectMapper(); // JSON <-> Object
		String json = objectMapper.writeValueAsString(role); // JSON형식을 문자열로 바꾸어 반환

		PrintWriter out = response.getWriter(); // 응답통로 생성
		out.println(json); // 응답결과로 보냄
		out.close();
	}
}