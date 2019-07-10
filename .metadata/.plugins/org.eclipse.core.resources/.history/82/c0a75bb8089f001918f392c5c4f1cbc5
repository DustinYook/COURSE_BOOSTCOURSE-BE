package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController 
{
	@RequestMapping(path="/userform", method=RequestMethod.GET) // @GetMapping과 같음
	public String userform() 
	{
		return "userForm";
	}
	
	@RequestMapping(path="/regist", method=RequestMethod.POST) // @PostMapping과 같음
	public String regist(@ModelAttribute User user) 
	{ 
		// 따로따로 받는 @RequestParam대신 한 번에 받을 수 있는 DTO같은 @ModelAttribute를 사용 
		// 그러면 요청을 받아 해당 부분에 값을 담아줌
		// form에서의 요청에서 name 속성값을 뽑아냄 -> User객체 생성 -> 값을 넣어줌
		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
	}
}