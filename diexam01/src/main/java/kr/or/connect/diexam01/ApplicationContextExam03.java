//package kr.or.connect.diexam01;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class ApplicationContextExam03 
//{
//	public static void main(String[] args) 
//	{
//		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // 스프링 컨테이너 생성 (공장)
//		
////		Car car = (Car) ac.getBean("car"); // 메소드 이름
//		Car car = (Car) ac.getBean(Car.class); // Car라는 클래스를 반환
//		car.run();
//	}
//}