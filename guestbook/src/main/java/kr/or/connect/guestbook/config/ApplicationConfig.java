package kr.or.connect.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 설정파일
@ComponentScan(basePackages = {"kr.or.connect.guestbook.dao", "kr.or.connect.guestbook.service"}) // 읽어들일 패키지 설정
@Import({DBConfig.class}) // 설정파일을 여러 개로 나누어 작성
public class ApplicationConfig { }