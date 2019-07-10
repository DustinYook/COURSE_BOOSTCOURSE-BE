package kr.co.connect.jdbcexam;

import java.util.List;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

public class JDBCExam5 
{
	public static void main(String[] args) 
	{
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();

		for(Role role : list) 
			System.out.println(role);
	} 
}