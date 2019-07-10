package kr.co.connect.jdbcexam;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

public class JDBCExam1 
{
	public static void main(String[] args) 
	{
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}
}