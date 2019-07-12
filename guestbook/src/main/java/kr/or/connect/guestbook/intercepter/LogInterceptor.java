package kr.or.connect.guestbook.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter 
{
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // 로거 객체를 생성
	
	/** preHandle: 컨트롤러 실행 전 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		/* println()을 이용한 로그 출력 */
		// System.out.println(handler.toString() + "를 호출했습니다.\n");
		
		/* 로거 객체를 이용한 로그 출력 */
		logger.debug("{}를 호출했습니다.%n", handler.toString());
		
		return true;
	}
	
	/** postHandle: 컨트롤러 실행 후 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception 
	{
		/* println()을 이용한 로그 출력 */
		// System.out.println(handler.toString() + "가 종료되었습니다.\n" + modelAndView.getViewName() + "를 view로 사용합니다.\n\n" );
	
		/* 로거 객체를 이용한 로그 출력 */
		logger.debug("{}가 종료되었습니다. {}를 view로 사용합니다.%n", handler.toString(), modelAndView.getViewName()); // 가변인자와 순서대로 매핑
	}
}