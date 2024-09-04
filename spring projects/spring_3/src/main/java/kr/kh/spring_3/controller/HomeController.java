package kr.kh.spring_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    	
	    	return "/main/home";
	    	
	    }
	
}
