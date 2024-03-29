package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JdbcTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // 스프링 컨테이너 생성
		RoleDao roleDao = ac.getBean(RoleDao.class); // 컨테이너로부터 Bean받아옴
		
		Role role = new Role();
		
		/** INSERT */
//		role.setRoleId(800);
//		role.setDescription("CEO");
//		int count = roleDao.insert(role); // 메소드의 결과로 int값이 리턴 (처리된 튜플수)
//		System.out.println(count + "건 입력하였습니다.");
		
		/** UPDATE */
//		role.setRoleId(800);
//		role.setDescription("Programmer");
//		int count = roleDao.update(role);
//		System.out.println(count + "건 수정하였습니다.");
		
		/** SELECT_BY_ID */
		Role result = roleDao.selectById(102);
		System.out.println(result);
		
		/** DELETE_BY_ID */
		int count = roleDao.deleteById(800);
		System.out.println(count + "건 삭제하였습니다.");
		result = roleDao.selectById(800); // 삭제되었는지 확인
		System.out.println(result);
		
	}
}