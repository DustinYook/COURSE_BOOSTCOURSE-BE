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
		response.setCharacterEncoding("utf-8"); // ������ ���ڵ� ����
		response.setContentType("application/json"); // JSON�� �̿�

		String pathInfo = request.getPathInfo(); // Path������ �о�� : /roles/{roleId} 
		String[] pathParts = pathInfo.split("/"); // ������ �������� �Ľ�
		String idStr = pathParts[1]; // roleId�� �ش��ϴ� ��
		int id = Integer.parseInt(idStr); // int������ �ٲ���

		RoleDao dao = new RoleDao(); // DAO ��ü ����
		Role role = dao.getRole(id); // id�� �ش��ϴ� Ʃ�� �о��

		ObjectMapper objectMapper = new ObjectMapper(); // JSON <-> Object
		String json = objectMapper.writeValueAsString(role); // JSON������ ���ڿ��� �ٲپ� ��ȯ

		PrintWriter out = response.getWriter(); // ������� ����
		out.println(json); // �������� ����
		out.close();
	}
}