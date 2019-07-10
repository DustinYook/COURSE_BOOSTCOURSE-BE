package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class SelectAllTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // 스프링 컨테이너 생성
		RoleDao roleDao = ac.getBean(RoleDao.class); // 스프링 컨테이너 통해 Bean받아옴

		List<Role> list = roleDao.selectAll(); // 모든 튜플 조회
		for(Role role : list) // 하나 하나 출력
			System.out.println(role);
	}
}