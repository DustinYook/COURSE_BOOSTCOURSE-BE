package kr.co.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.connect.jdbcexam.dto.Role;

public class RoleDao 
{
	// 계속 반복적으로 사용되므로 클래스 멤버로 등록하는게 좋음
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "user";
	private static String dbpasswd = "connect123!@#";
	
	public List<Role> getRoles() // List로 리턴
	{
		List<Role> list = new ArrayList<Role>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로드
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role ORDER BY role_id DESC";
		// try-with-resource 구문 : 기존의 close를 써 줄 필요없이 자동으로 처리해줌 (finally로 작성했던 부분이 없음)
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); PreparedStatement ps = conn.prepareStatement(sql))
		{
			try(ResultSet rs = ps.executeQuery()) 
			{
				while(rs.next()) // 있으면 true리턴하며 커서 다음 튜플로 이동
				{
					String description = rs.getString(1); // 꺼내서
					int id = rs.getInt("role_id");
					Role role = new Role(id, description); // Role객체를 생성
					list.add(role); // list에 반복할 때마다 Role인스턴스를 생성하여 list에 추가함
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	/** SELECT */
	public Role getRole(Integer roleId)
	{
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 예외가 굉장히 많이 발생
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩 : com.mysql.jdbc.Driver
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어옴
			String sql = "SELECT description, role_id FROM role WHERE role_id = ?"; // 인자값이 무엇이 들어왔느냐에 따라 바뀌는 부분을 ?로 표시
			ps = conn.prepareStatement(sql); // stmt 객체를 받아옴
			ps.setInt(1, roleId); // 첫번째 인자 : 물음표의 인덱스, 두번째 인자 : 값 - roleId가 int이기 때문에 setInt() 사용 
			rs = ps.executeQuery(); // 쿼리를 실행해주세요
			
			if(rs.next()) // 결과값 있으면 다음 레코드로 커서 이동 true리턴, 없으면 false 리턴
			{
				String description = rs.getString(1); // 인덱스로도 가능
				int id = rs.getInt("role_id"); // 속성명을 가져올 수도 있음
				role = new Role(id, description); // Role 객체 생성
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally // 반드시 수행되는 구절 - 객체 닫아주는 역할 수행
		{ 
			// ps, conn에서 예외 발생시 rs는 반드시 NullPointerException이 발생
			if(rs != null)
			{
				try { rs.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
			
			if(ps != null)
			{
				try { ps.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
						
			if(conn != null)
			{
				try { conn.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return role;
	}
	
	/** INSERT */
	public int addRole(Role role) // 한 건을 입력하는 메소드 (입력값을 인자로 받아옴)
	{
		int insertCount = 0; // 몇 개 수정했는지 알려줌
		
		Connection conn = null;
		PreparedStatement ps = null;
		// insert라 ResultSet이 필요없음
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어옴
			
			String sql = "INSERT INTO role(role_id, description) VALUES (? , ?)";
			ps = conn.prepareStatement(sql); 
			
			// 물음표를 바인딩하는 코드, 첫째 인자는 인덱스
			ps.setInt(1,  role.getRoleId()); 
			ps.setString(2,  role.getDescription());
			
			insertCount = ps.executeUpdate(); // 쿼리 실행하는 코드 (select와 다름) 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null)
			{
				try { ps.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
						
			if(conn != null)
			{
				try { conn.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return insertCount;
	}
	
	/** UPDATE */
	public int updateRole(Role role)
	{
		int updateCount = 0; // 몇 개 수정했는지 알려줌
		
		Connection conn = null;
		PreparedStatement ps = null;
		// update라 ResultSet이 필요없음
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어옴
			
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";
			ps = conn.prepareStatement(sql); 
			
			// 물음표를 바인딩하는 코드, 첫째 인자는 인덱스
			ps.setString(1,  role.getDescription());
			ps.setInt(2, role.getRoleId());
			
			updateCount = ps.executeUpdate(); // 쿼리 실행하는 코드 (select와 다름) 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null)
			{
				try { ps.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
						
			if(conn != null)
			{
				try { conn.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return updateCount;
	}
	
	/** DELETE */
	public int deleteRole(Integer roleId)
	{
		int deleteCount = 0; // 몇 개 수정했는지 알려줌
		
		Connection conn = null;
		PreparedStatement ps = null;
		// delete라 ResultSet이 필요없음
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어옴
			
			String sql = "DELETE FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql); 
			
			// 물음표를 바인딩하는 코드, 첫째 인자는 인덱스
			ps.setInt(1,  roleId); 
			deleteCount = ps.executeUpdate(); // 쿼리 실행하는 코드 (select와 다름) 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null)
			{
				try { ps.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
						
			if(conn != null)
			{
				try { conn.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return deleteCount;
	}
}