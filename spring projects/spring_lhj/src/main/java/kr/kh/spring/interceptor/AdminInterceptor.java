package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

// 관리자만 관리자 페이지에 접근할 수 있께 하기 위해서 ... ( servlet 에서는 filter 를 이용해서 구현했다. )
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			// 로그인한 회원 정보를 가져온다.
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
			// 로그인한 회원이 없거나 관리자가 아니면 메인페이지로 이동시킨다.
			if(user == null || !user.getMe_authority().equals("ADMIN")) {
				
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().write("<script>alert(\"관리자만 접근할 수 있습니다.\")</script>");
				response.getWriter().write("<script>location.href=\"" + request.getContextPath() + "/" + "\"</script>");
				response.flushBuffer();
				
				return false; // 지정한 경로로 이동시키기 위해 false 로 return 을 해야한다. 
			}
			// 아니면 관리자일 경우, 그대로 진행한다.
			return true;
			
	}
	
}
