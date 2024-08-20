package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(request, response);
	}

	// doPost 도 필요하다. ( 나는 지웠었다. )
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 입력한 아이디를 가져온다.
		String me_id = request.getParameter("me_id");
		// 입력한 비밀번호를 가져온다.
		String me_pw = request.getParameter("me_pw");
		// 입력한 이메일을 가져온다.
		String me_email = request.getParameter("me_email");
		
		// 위 정보를 가진 하나의 객체를 만든다.
		MemberVO member = new MemberVO(me_id, me_pw, me_email);
		
		// 여기까지는 했다. ( 나 혼자 ... )
		// 밑은 이전에 했던 것 참고해서 가져왔다.
		
		if(memberService.signup(member)) {
			request.setAttribute("msg", "회원가입에 성공하였습니다.");
			request.setAttribute("url", "/");
		} else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			request.setAttribute("url", "/signup");
		}
		
		// 다시 한번 못 적었다. 가져오고나서 띄워야 하는데, 가져오기만 했다. forward 꼭 적어줘야한다.
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}
