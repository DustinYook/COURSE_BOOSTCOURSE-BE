package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 
{
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); // 스프링 컨테이너 생성
		
		Car car = (Car) ac.getBean("c"); // 스프링 컨테이너가 나 대신 생성 (IoC)
		car.run();
	}
}