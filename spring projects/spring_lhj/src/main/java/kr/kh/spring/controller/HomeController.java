package kr.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;


@Controller
public class HomeController {
	
	// private MemberService memberservice = new MemberServiceImp();
	
	// servlet 에서는 위와 같이 작성했다, spring 에서는 @Autowired 를 추가한 후, 아래와 같이 작성하면 된다.
	
	@Autowired
	private MemberService memberService;
	
	// int 는 null을 저장하지 못한다.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @GetMapping("/") 로 줄여서 작성할 수 있다.
	
	// value = url
	// 2가지 방식으로 처리하고 싶다면, method 를 삭제하면 된다.
	
	// 리턴 타입을 void 로 한다면 url 이 리턴된다.
	
	public String home(Model model, PersonDTO person) {
		
		// 화면에서 보낸 정보를 객체로 받는 경우 실행 과정
		// 1. 해당 클래스의 기본 생성자가 호출
		// 2. 화면에서 보낸 name 과 같은 멤버 변수들의 setter 를 호출해서 값을 변경
		
		System.out.println(person);
		
		model.addAttribute("name", "홍길동");
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원 가입을 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "회원 가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "/main/message";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		MemberVO user = memberService.login(member);
		if(user != null) {
			model.addAttribute("msg", "로그인을 성공했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인을 실패했습니다.");
			model.addAttribute("url", "/login");
		}
		session.setAttribute("user", user);
		return "/main/message";
	}
	
}
