package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 페이지로 오기 이전의 URL 을 가져온다.
		String url = request.getHeader("Referer");
		
		// URL 이 있거나 /login 이 아니면 세션에 URL 을 저장
		if(url != null && !url.contains("/login")) {
			// 이전 url 이라는 뜻으로 prevUrl 으로 명명
			request.getSession().setAttribute("prevUrl", url);
		}
		// getRequestDispatcher = 가져오는 기능, forward = 전송하는 기능.
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// doPost 에서 해야할 것.
		// 화면에서 입력한 아이디, 비밀번호를 이용해서 회원 정보를 가져오고, 가져온 회원 정보를 세션에 저장.
		
		// 1. 화면에서 입력한 아이디, 비밀번호를 가져온다.
		
		// 입력한 아이디를 가져온다.
		String me_id = request.getParameter("me_id");
		
		// 입력한 비밀번호를 가져온다.
		String me_pw = request.getParameter("me_pw");
		
		// 2. 아이디, 비밀번호를 이용해서 회원 정보를 가져온다.
		
		// 입력한 아이디와 비밀번호를 객체로 작성. ( 묶어서 보내는 것이 편하기 때문에 객체를 만든다. )
		MemberVO member = new MemberVO(me_id, me_pw);
		
		MemberVO user = memberService.login(member); // 이거 못 했다.
		
		// 3. 가져온 회원 정보를 세션에 저장한다. ( 로그인 유지를 위해 ) // 이거 못 했다.
		request.getSession().setAttribute("user", user );
		
		// DB에 저장된 '아이디/비밀번호' 와 입력한 '아이디/비밀번호'가 일치하면 로그인 성공, 아니면 로그인 실패
		// if 내부 조건문을 적지 못했다.
		if(user != null) {
			request.setAttribute("msg", "로그인에 성공하였습니다.");
			request.setAttribute("url", "/");
			
			// 자동 로그인을 체크했다면
			String auto = request.getParameter("auto");
				if(auto != null && auto.equals("true")) {
					// 쿠키를 생성하고 DB에 쿠키와 만료시간을 저장. ( 회원 정보와 세션이 필요하다. )
					Cookie cookie = memberService.createCookie(user, request);
					response.addCookie(cookie);
				}
			
		} else {
			request.setAttribute("meg", "로그인에 실패하였습니다.");
			request.setAttribute("url", "/login");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
