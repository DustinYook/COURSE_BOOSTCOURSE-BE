package kr.co.connect.jdbcexam;

import kr.co.connect.jdbcexam.dao.RoleDao;

public class JDBCExam3
{
	public static void main(String[] args) 
	{
		int roleId = 500;
		
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roleId);
		System.out.println(deleteCount);
	}
}