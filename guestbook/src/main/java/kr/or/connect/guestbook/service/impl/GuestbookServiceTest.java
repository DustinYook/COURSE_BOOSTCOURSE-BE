package kr.or.connect.guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

public class GuestbookServiceTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // 스프링 컨테이너
		GuestbookService guestbookService = ac.getBean(GuestbookService.class); // Bean 얻어옴
	
		Guestbook guestbook = new Guestbook();
		guestbook.setName("kang kyungmi33");
		guestbook.setContent("Nice to meet you! ^^33");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
	}
}