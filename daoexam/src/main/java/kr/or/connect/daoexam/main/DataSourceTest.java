/** 설정파일에 의해 DataSource가 제대로 생성되고 접속이 제대로 잘 되는지 확인 */
package kr.or.connect.daoexam.main;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// 설정파일을 읽어들여 ApplicationContext(IoC/DI 컨테이너) 생성 
		DataSource ds = ac.getBean(DataSource.class); // DataSource 객체 요청
		
		Connection conn = null;
		try
		{
			conn = ds.getConnection(); // ds로부터 커넥션을 얻어옴
			if(conn != null)
				System.out.println("접속 성공 ^^");
		}
		catch(Exception e) { e.printStackTrace(); }
		finally
		{
			if(conn != null)
			{
				try { conn.close(); }
				catch(Exception e) { e.printStackTrace(); }
			}
		}
	}
}