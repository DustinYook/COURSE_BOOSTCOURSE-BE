package kr.co.connect.wordcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.connect.jdbcexam.dto.Role;

public class CardDao 
{
	// 계속 반복적으로 사용되므로 클래스 멤버로 등록하는게 좋음
	private static String dburl = "jdbc:mysql://localhost:3306/wordcard";
	private static String dbUser = "user";
	private static String dbpasswd = "connect123!@#";

	/** INSERT */
	public int addCard(Card card) // 한 건을 입력하는 메소드 (입력값을 인자로 받아옴)
	{
		int insertCount = 0; // 몇 개 수정했는지 알려줌
		
		Connection conn = null;
		PreparedStatement ps = null;
		// insert라 ResultSet이 필요없음
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // connection 객체 얻어옴
			
			String sql = "INSERT INTO card(word, description) VALUES (? , ?)";
			ps = conn.prepareStatement(sql); 
			
			// 물음표를 바인딩하는 코드, 첫째 인자는 인덱스
			ps.setString(1, card.getWord()); 
			ps.setString(2, card.getDescription());
			
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
}