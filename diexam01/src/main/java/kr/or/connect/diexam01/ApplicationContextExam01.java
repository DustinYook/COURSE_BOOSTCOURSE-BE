package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 해당 설정파일을 읽어들이는 객체
public class ApplicationContextExam01 
{
	public static void main(String[] args) 
	{
		// ApplicationContext는 interface -> 구현하는 다양한 컨테이너 존재
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml"); // Bean이 등록된 위치를 알려줌
		System.out.println("초기화 완료");
		
		UserBean userBean = (UserBean) ac.getBean("userBean"); // 공장을 통해 인스턴스 얻어냄 : Object로 리턴해서 형변환 필요
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean) ac.getBean("userBean");
		if(userBean == userBean2)
			System.out.println("같은 인스턴스입니다."); // ApplicationContext는 싱글톤 패턴 이용
		// 사용자가 getBean()으로 계속 요청해도 객체를 계속 만드는게 아니라 하나 만든 Bean을 이용
	}
}