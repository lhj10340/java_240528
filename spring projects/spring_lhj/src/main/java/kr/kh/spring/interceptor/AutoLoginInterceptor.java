package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		// 이미 로그인이 되어있으니 실행할 필요 없다.
		
		if(user != null ) {
			return true;
		} 
		
		// 로그인이 되지 않았으면 LC 쿠키가 없으면, 그대로 지나간다.
		// LC 쿠키를 가져온다.
		
		Cookie cookie = WebUtils.getCookie(request, "LC");
		
		if(cookie == null) {
			return true;
		}
		// LC 쿠키가 있다면
		String sid = cookie.getValue();
		user = memberService.getMemberByCookie(sid);
		
		if(user != null) {
			session.setAttribute("user", user);
		}
			return true;
	}
	
}
