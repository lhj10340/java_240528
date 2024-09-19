package kr.kh.spring_3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring_3.model.dto.MessageDTO;
import kr.kh.spring_3.model.vo.CommunityVO;
import kr.kh.spring_3.model.vo.MemberVO;
import kr.kh.spring_3.service.MemberService;
import kr.kh.spring_3.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	  @Autowired
	    MemberService memberService;
	    
	  @Autowired
	    PostService postService;
	  
	    @RequestMapping(value="/")
	    public String home(Model model) {
	    	
	    	log.info("/ : 메인페이지입니다. ");
	    	
	    	model.addAttribute("title", "메인");
	    	
	    	return "/main/home";
	    	
	    }
	    
	    @GetMapping("/guest/signup")
	    public String guestSignup() {
	    	return "/member/signup";
	    }
	    
	    @PostMapping("/guest/signup")
	    public String guestSignupPost(Model model, MemberVO member) {
	    	
	    	boolean res = memberService.signup(member);
	    	
	    	MessageDTO message;
	    	
	    	if(res) {
	    		message = new MessageDTO("/", "회원가입에 성공했습니다");
	    	} else {
	    		message = new MessageDTO("/guest/signup", "회원가입에 실패했습니다");
	    	}
	    	
	    	model.addAttribute("message", message);
	    	
	    	return "/main/message";
	    }
	    
	    @GetMapping("/guest/login")
	    public String guestLogin() {
	    	log.info("/guest/login:get");
	    	return "/member/login";
	    }
	    
	    @PostMapping("/guest/login")
	    public String guestLoginPost(Model model, HttpSession session, MemberVO member) {
	    	
	    	log.info("/guest/login:post");
	    	
	    	// 이 부분도 처음에는 회원가입과 동일하게 작성했다가, 이전꺼 보고 수정했다.
	    	MemberVO user = memberService.login(member);
	    	
	    	MessageDTO message;
	    	
	    	// 로그인을 한 후, 이를 일정시간동안 유지하기 위하여 세션을 부여해야한다.
	    	// 세션을 부여하는 방법을 입력하지 못했다.
	    	// session.setAttribute("user", user);
	    	
	    	if(user != null) {
	    		message = new MessageDTO("/", "로그인에 성공했습니다");
	    		session.removeAttribute("id");
	    	} else {
	    		message = new MessageDTO("/guest/login", "로그인에 실패했습니다");
	    		session.setAttribute("id", member.getMe_id());
	    	}
	    	
	    	model.addAttribute("message", message);
	    	
	    	// interceptor 을 이용할거니까 여기서 세션을 부여하는게 아니다, 정보를 넘겨만 준다.
	    	model.addAttribute("user", user);
	    	
	    	return "/main/message";
	    }
	    
	    @GetMapping("/member/logout")
	    public String memberLogout(Model model, HttpSession session, MemberVO member) {
	    	
	    	log.info("/member/logout:get");

	    	session.removeAttribute("user");
	    	
	    	MessageDTO message = new MessageDTO("/", "로그아웃 성공");
	    	model.addAttribute("message", message);
	    	
	    	return "/main/message";
	    }
	    
	    @ResponseBody
	    @GetMapping("/test")
	    public String test() {
	    	return "Hello";
	    }
	    
	    @ResponseBody
	    @GetMapping("/test2")
	    public List<CommunityVO> test2() {
	    	return postService.getCommunityList();
	    }
}
