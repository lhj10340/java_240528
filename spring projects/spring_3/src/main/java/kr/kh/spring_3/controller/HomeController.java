package kr.kh.spring_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring_3.model.dto.MessageDTO;
import kr.kh.spring_3.model.vo.MemberVO;
import kr.kh.spring_3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	  @Autowired
	    MemberService memberService;
	    
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
	    
}
