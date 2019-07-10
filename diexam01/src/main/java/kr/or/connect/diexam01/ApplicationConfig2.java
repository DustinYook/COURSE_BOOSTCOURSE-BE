package kr.or.connect.diexam01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // config임을 알림
@ComponentScan("kr.or.connect.diexam01") // 알아서 구성요소 추가해라 (반드시 패키지명을 알려줘야 함)
public class ApplicationConfig2 { }