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
		response.setCharacterEncoding("utf-8"); // ������ ���ڵ� ����
		response.setContentType("application/json"); // JSON���� ����
		
		RoleDao dao = new RoleDao(); // DAO ��ü ����
		List<Role> list = dao.getRoles(); // Role�� ����Ʈ�� ��

		ObjectMapper objectMapper = new ObjectMapper(); // JSON <-> ��ü 
		String json = objectMapper.writeValueAsString(list); // ����Ʈ�� JSON������ ���ڿ��� �ٲ�� ����

		PrintWriter out = response.getWriter(); // ������ ������� ����
		out.println(json); // �������� �־���
		out.close();
	}
}