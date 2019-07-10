package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

/** Servlet implementation class RolesServlet */
@WebServlet("/roles")
public class RolesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /** @see HttpServlet#HttpServlet() */
    public RolesServlet() { super(); }

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("utf-8"); // 응답결과 인코딩 세팅
		response.setContentType("application/json"); // JSON으로 응답
		
		RoleDao dao = new RoleDao(); // DAO 객체 생성
		List<Role> list = dao.getRoles(); // Role의 리스트를 얻어냄

		ObjectMapper objectMapper = new ObjectMapper(); // JSON <-> 객체 
		String json = objectMapper.writeValueAsString(list); // 리스트가 JSON형식의 문자열로 바뀌어 리턴

		PrintWriter out = response.getWriter(); // 응답결과 전송통로 생성
		out.println(json); // 응답결과로 넣어줌
		out.close();
	}
}