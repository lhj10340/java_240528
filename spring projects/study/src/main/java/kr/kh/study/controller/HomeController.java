package kr.kh.study.controller;

import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.study.dao.PostDAO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	PostDAO postDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println(postDao.count());
		
		String str = "abc";
		String enc = passwordEncoder.encode(str);
		System.out.println("암호화 안 된 문자열 : " + str);
		System.out.println("암호화 된 문자열 : " + enc);
		System.out.println("암호화된 문자열 == abc : " + passwordEncoder.matches("abc", enc));
		System.out.println("암호화된 문자열 == abd : " + passwordEncoder.matches("abd", enc));
		
//		mailSend("lhj10340@naver.com", "메일 테스트", "전송 완료");
		
		return "/home";
	}
	
	@GetMapping("/post/list")
	public String postList() {
		return "/home";
	}
	
	@GetMapping("/post/detail")
	public String postDetail() {
		return "/home";
	}
	
	@GetMapping("/post/insert")
	public String postInsert() {
		return "/home";
	}
	
//	@Autowired
//	private JavaMailSender mailSender;
//
//	public boolean mailSend(String to, String title, String content) {
//
//	    String setfrom = "lhj10340@naver.com";
//	   try{
//	        MimeMessage message = mailSender.createMimeMessage();
//	        MimeMessageHelper messageHelper
//	            = new MimeMessageHelper(message, true, "UTF-8");
//
//	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
//	        messageHelper.setTo(to);// 받는사람 이메일
//	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
//	        messageHelper.setText(content, true);// 메일 내용
//
//	        mailSender.send(message);
//	        return true;
//	    } catch(Exception e){
//	        e.printStackTrace();
//	        return false;
//	    }
	}

