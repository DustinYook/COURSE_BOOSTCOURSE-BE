package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 컨트롤러임을 알려줌
public class PlusController 
{
	// 요청이 plusform과 plus로 2개 존재 -> 각각을 위한 메소드 필요
	
	@GetMapping(path = "/plusform") // 스프링 버전 4.3부터 사용가능
	public String plusform() // 뷰 네임을 넘겨줌
	{
		return "plusForm"; 
		// WebMvcControllerConfiguation.InternalResourceViewResolver()에 의해 
		// WEB-INF/views/plusForm.jsp로 변환됨
	}
	
	/** 역할 : form에서 값을 받아서 더한 다음에 결과를 request scope에 넘겨줌 */
	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value1", required = true) int value1, @RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) 
	{
		// @RequestParam(name = "value1", required = true) int value1 : 1을 2에다 넣어달라는 의미
		// 1) @RequestParam(name = "value1", required = true) : form에서 넘어온 요청인자 (이름은 value1이고 필수속성)
		// 2) int value1은 현재 plus()메소드에서 사용할 변수
		
		int result = value1 + value2;
		
		// 왜 requestScope에 직접 setAttribute()안하냐? - 웹에 종속되는 것 방지
		// 대신 스프링에서 제공하는 객체를 이용하여 설정하는 것이 바람직하다.
		modelMap.addAttribute("value1", value1); // (key, value)
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		
		return "plusResult"; // 뷰 네임을 리턴
		// WebMvcControllerConfiguation.InternalResourceViewResolver()에 의해 
		// WEB-INF/views/plusResult.jsp로 변환됨
	}
}