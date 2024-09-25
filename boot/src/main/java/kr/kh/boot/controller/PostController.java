package kr.kh.boot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PageMaker;
import kr.kh.boot.pagination.PostCriteria;
import kr.kh.boot.service.PostService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {
	
	private PostService postService;
	
	// @PathVariable 의 소괄호 내용과 변수의 이름이 같다면, 소괄호 내용을 삭제하고도 사용할 수 있다.
	
	@GetMapping("/post/list/{co_num}")
	public String postList(Model model, @PathVariable int co_num, PostCriteria cri) {
		
		cri.setCo_num(co_num);
		cri.setPerPageNum(4);
		
		// 커뮤니티 번호에 맞는 게시글 목록을 가져와서 화면에 전달
		List<PostVO> list = postService.getPostList(cri);
		
		// 커뮤니티 목록을 가져와서 화면에 전달 // () 안에 아무것도 필요가 없었다 ... 난 co_num 넣었다.
		List<CommunityVO> list_1 = postService.getCommunityList();
		
		// 현재 페이지 정보를 이용해서 페이지메이커를 가져와서 화면에 전달한다.
		PageMaker pm = postService.getPageMaker(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("list_1", list_1);
		model.addAttribute("pm", pm);
		
		return "post/list";
	}
	
	@GetMapping("/post/detail/{po_num}")
	public String postDetail(Model model, @PathVariable int po_num) {
		
		// detail.html 을 만들지 않았었다.
		// 조회 메소드 작성 시, 조회수 증가 메소드 작성하는 것 빼먹지 말자 ...
		
		postService.updateView(po_num);
		
		PostVO post = postService.getPost(po_num);
		
		model.addAttribute("post", post);
		
		return "post/detail";
	}
	
}
