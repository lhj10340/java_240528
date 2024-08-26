package kr.kh.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;


@Controller
public class HomeController {
	
	// private MemberService memberservice = new MemberServiceImp();
	
	// servlet 에서는 위와 같이 작성했다, spring 에서는 @Autowired 를 추가한 후, 아래와 같이 작성하면 된다.
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		String email = memberService.getEmail("abc123");
		System.out.println(email);
		return "home";
	}
	
}
