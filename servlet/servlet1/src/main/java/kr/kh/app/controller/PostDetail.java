package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 번호를 가져온다.
		String numStr = request.getParameter("num");
		try {
			int num = Integer.parseInt(numStr);
			// 조회수 증가
			postService.updatePostView(num);
			// 가져온 게시글 번호에 맞는 게시글 정보를 가져오라고 시킨다.
			PostVO post = postService.getPost(num);
			// 게시글을 화면에 전송
			request.setAttribute("post", post);
			
			// 로그인한 회원의 추천 정보를 가져온다.
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			RecommendVO recommend = postService.getRecommend(num, user);
			request.setAttribute("re", recommend);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}

}
