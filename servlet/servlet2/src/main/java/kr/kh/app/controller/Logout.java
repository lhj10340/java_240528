package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션에 있는 정보를 지우고 알리면 된다. ( 내용 파악은 했는데, 코딩을 못 했다. 너무 쉬웠는데, 아쉽다. )
		request.getSession().removeAttribute("user");
		
		// 알리기
		request.setAttribute("msg", "로그아웃 했습니다.");
		// 메인 페이지로 이동
		request.setAttribute("url", "/");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
	
}
