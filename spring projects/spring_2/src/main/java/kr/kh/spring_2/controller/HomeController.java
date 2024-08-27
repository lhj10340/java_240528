package kr.kh.spring_2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring_2.model.vo.MemberVO;
import kr.kh.spring_2.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
    MemberService memberService;
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "/main/home";
	}
	
	// 같은 데이터 전달방식 + url 일 경우, 에러가 난다. 주의해야한다.
	
	@GetMapping("/signup")
	public String signup() {
		
		return "/member/signup";
	}
	
	@PostMapping()
	public String signupPost(Model model, MemberVO member) {
		
		if(memberService.signup(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "회원가입을 했습니다.");
		} else {
			model.addAttribute("url", "/signup");
			model.addAttribute("msg", "회원가입을 하지 못했습니다.");
		}
		
		return "/main/message";
		}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	// 내가 한 것.
	
	/*@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		
		if(memberService.login(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인 완료!");
		} else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인 실패!");
		}
		
		return "/main/message";
	} */
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		
		// 로그인을 완료하면, 회원 정보를 불러와야한다. 그래서 밖으로 빼서 작업했다.
		
		MemberVO user = memberService.login(member);
		
		// session 을 빼먹어서, 로그인을 해도 ' 로그인, 회원가입 ' 링크가 사라지지 않았다.
		// 로그인 코딩을 할 때, 필수적으로 해야한다.
		
		session.setAttribute("user", user);
		
		if(user != null) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인을 했습니다.");
		} else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인을 하지 못했습니다.");
		}
		
		return "/main/message";
		}
	
	}
	
