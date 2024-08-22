package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/insert")
public class PostInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 커뮤니티 번호를 가져와서 화면에 전달
		String co_num = request.getParameter("co_num");
		
		request.setAttribute("co_num", co_num);
		request.getRequestDispatcher("/WEB-INF/views/post/insert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		
		// 입력한 제목을 가져온다.
		String title = request.getParameter("title");
		// 입력한 내용을 가져온다.
		String content = request.getParameter("content");
		// 입력한 제목과 내용을 하나의 객체로 생성한다.
		PostVO newPost = new PostVO(title, content);
		// 새로운 게시글을 등록한다.
		PostVO post = postService.postInsert(newPost);
		
		*/
		
		// 화면에서 게시글 정보를 가져와서 게시글을 등록한다. // 여기는 못 했다.
		
			// 1. 제목, 내용, 커뮤니티 번호를 가져온다.
			String title = request.getParameter("po_title");
			String content = request.getParameter("po_content");
			String co_num = request.getParameter("po_co_num");
			// 2. 로그인한 회원 정보를 가져온다.
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			// 3. 제목, 내용, 커뮤니티, 회원 아이디를 이용해서 게시글 객체를 생성한다.
			PostVO post = new PostVO(co_num, title, content, user.getMe_id());
			// 4. 게시글 객체를 등록 시킨다ㅣ
			boolean res = postService.insertPost(post);
			System.out.println(post);
		// 등록여부에 맞게 알림처리
		
			if(res) {
				
				request.setAttribute("msg", "게시글을 등록했습니다." );
				request.setAttribute("url", "/post/list?co_num=" + co_num );
			} else {
				
				request.setAttribute("msg", "게시글을 등록하지 못했습니다." );
				request.setAttribute("url", "/post/insert?co_num="+ co_num );
			}
			
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}
}
