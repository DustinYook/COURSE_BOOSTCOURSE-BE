package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 설정파일임을 선언
@ComponentScan(basePackages = {"kr.or.connect.daoexam.dao"}) // 대상 패키지를 지정해야 함 (여러 개도 가능)
@Import({DBConfig.class}) // 설정파일을 여러개로 나누어 작성가능하게 해주는 어노테이션
public class ApplicationConfig { }