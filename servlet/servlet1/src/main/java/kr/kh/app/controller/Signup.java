package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		LoginDTO member = new LoginDTO(id,pw,email);
		
		if(memberService.signup(member)) {
			request.setAttribute("msg", "회원 가입에 성공했습니다.");
			request.setAttribute("url", "/");
		}else {
			request.setAttribute("msg", "회원 가입에 실패했습니다.");
			request.setAttribute("url", "/signup");
		}
		// forward를 붙이지 않으면, 정보를 가져오기만 한 상태라서 이동이 되지 않는다.
		// 회원가입이 완료되도 메세지가 나오지 않고, 이동도 되지 않는다.
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
