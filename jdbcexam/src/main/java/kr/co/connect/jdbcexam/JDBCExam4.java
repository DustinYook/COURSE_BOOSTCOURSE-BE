package kr.co.connect.jdbcexam;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

public class JDBCExam4
{
	public static void main(String[] args) 
	{
		int roleId = 500;
		String description = "CIO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		System.out.println(updateCount);
	}
}