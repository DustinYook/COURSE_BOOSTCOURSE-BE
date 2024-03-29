package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuestbookAdminController 
{
	@GetMapping(path = "/loginform")
	public String loginform()
	{
		// 요청이 들어오면 해당 view에 대한 정보를 넘겨줌
		return "loginform";
	}
	
	@PostMapping(path = "/login")
	public String login(@RequestParam(name="passwd", required=true) String passwd,
			HttpSession session, RedirectAttributes redirectAttr)
	{
		// loginform으로부터 패스워드를 입력받아 암호가 일치할 때 세션에 로그인 정보 저장 
		if("1234".equals(passwd)) // 원래는 DB와 연동해야 함!
		{
			session.setAttribute("isAdmin", true);
			session.setMaxInactiveInterval(60 * 60);
		}
		else
		{
			// RedirectAttributes는 DispatcherServlet이 관리하는 FlashMap에 값을 저장
			// 목적 : redirect할 때 값을 딱 한번만 유지할 목적으로 사용
			redirectAttr.addFlashAttribute("errorMessage", "암호가 틀렸습니다.");
			return "redirect:/loginform";
		}
		return "redirect:/list";
	}
	
	@GetMapping(path="/logout")
	public String login(HttpSession session)
	{
		session.removeAttribute("isAdmin"); // 설정된 세션을 삭제
		return "redirect:/list";
	}
}