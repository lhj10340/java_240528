package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.service.MemberService;


@Controller
public class HomeController {
	
	// private MemberService memberservice = new MemberServiceImp();
	
	// servlet 에서는 위와 같이 작성했다, spring 에서는 @Autowired 를 추가한 후, 아래와 같이 작성하면 된다.
	
	@Autowired
	private MemberService memberService;
	
	// int 는 null을 저장하지 못한다.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, PersonDTO person) {
		
		// 화면에서 보낸 정보를 객체로 받는 경우 실행 과정
		// 1. 해당 클래스의 기본 생성자가 호출
		// 2. 화면에서 보낸 name 과 같은 멤버 변수들의 setter 를 호출해서 값을 변경
		// 
		System.out.println(person);
		
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
}
