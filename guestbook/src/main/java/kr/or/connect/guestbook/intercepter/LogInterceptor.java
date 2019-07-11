package kr.or.connect.guestbook.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter 
{
	/** preHandle: 컨트롤러 실행 전 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		System.out.println(handler.toString() + "를 호출했습니다.\n");
		return true;
	}
	
	/** postHandle: 컨트롤러 실행 후 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception 
	{
		System.out.println(handler.toString() + "가 종료되었습니다.\n" + modelAndView.getViewName() + "를 view로 사용합니다.\n\n" );
	}
}