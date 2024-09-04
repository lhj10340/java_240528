package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

// 로그인 후, 이전 페이지로 이동할 때

public class PrevUrlInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		
		HttpSession session = request.getSession();
		
		// 세션에 이전 url 정보를 가져온다.
		String prevUrl = (String)session.getAttribute("prevUrl");
		// 이전 url 이 없으면 종료.
		if(prevUrl == null) {
			return;
		}
		// 로그인한 회원 정보를 가져온다.
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 로그인한 회원 정보가 없다면, 종료한다.
		if(user == null) {
			return;
		}
		// 이전 url 로 리다이렉트 후, 이전 url 을 제거한다.
		response.sendRedirect(prevUrl);
		session.removeAttribute("prevUrl");
	}
	
}
