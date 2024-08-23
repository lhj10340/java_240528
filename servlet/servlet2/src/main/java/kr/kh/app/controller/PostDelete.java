package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
	
    // get 이나 post 나 상관없다고 하셨지만, get 으로 수업 진행하셔서 바꿔놓았다. 다만, post 를 사용할 경우 jsp 에서 form 을 사용해야한다고 하셨다.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 게시글 번호를 불러온다.
		String po_num = request.getParameter("po_num");
		
		// 로그인을 한 회원의 정보를 불러온다.
		// 로그인을 한 회원만 삭제버튼을 볼 수 있음에도 이 코드를 작성하는 이유는, 개발자 모드를 통해 다른 글을 삭제할 위험이 있기 때문.
		// "user" 를 적은 이유는 login servlet 에서 로그인한 회원을 "user" 로 받았기 때문.
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 게시글 번호를 이용하여 게시글을 불러온다.
		// PostVO post = postService.getPost(po_num);
		// 이건 딱히 필요가 없었다.
		
		// boolean 대신 int 를 사용한 이유는 삭제 완료 후, 되돌가는 과정에서 편하려고 ...
		int co_num = postService.deletePost(po_num, user);
		
		// 삭제 성공 여부에 따라 메세지 및 url 작성
		// != 이면 삭제된 것.
		
		if(co_num != 0) {
			
			request.setAttribute("msg", "게시글 삭제에 성공하였습니다.");
			// 게시판으로 돌아가니까 co_num 으로 수정.
			request.setAttribute("url", "/post/list?co_num=" + co_num);
		} else {
			
			request.setAttribute("msg", "게시글 삭제에 실패하였습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + po_num);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
