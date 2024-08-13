package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/comment/list")
// URL 의 경우 정하기 나름이다. 폴더 이름이 아니다.

public class CommentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 여기서는 cri 를 사용하기 때문에 detail.jsp 에 있는 객체 cri를 보고 가져와야 한다.
		// 내가 이해했던 jsp 에서 name 을 가져오는 것은 form 태그에 있는 경우가 그렇
		
		String num = request.getParameter("num");
		String pageStr = request.getParameter("page");
		
		JSONObject jobj = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		try {
			
			int po_num = Integer.parseInt(num);
			int page = Integer.parseInt(pageStr);
			Criteria cri = new CommentCriteria(page, 2, po_num);
			// 댓글 목록
			List<CommentVO> list = postService.getCommentList(cri);
			// 댓글 페이지네이션
			PageMaker pm = postService.getCommentPageMaker(cri);
			jobj.put("list", list);
			jobj.put("pm", om.writeValueAsString(pm));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
		
	}

}
