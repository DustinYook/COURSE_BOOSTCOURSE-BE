package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car 
{
	@Autowired // 알아서 객체 있으면 여기에 주입해달라
	private Engine v8;
	
	// 기본 생성자
	public Car() { System.out.println("Car 생성자"); }

//	public void setEngine(Engine e) { this.v8 = e; }
	
	public void run()
	{
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec(); // 엔진이 가진 메소드를 실행 
	}
	
	// IoC 없이 작성된 코드
//	public static void main(String[] args) 
//	{
//		Engine e = new Engine(); // IoC로 넘길 부분 - Spring 컨테이너가 수행
//		Car c = new Car(); // IoC를 넘길 부분 - Spring 컨테이너가 수행
//		c.setEngine(e);
//		c.run();
//	}
}