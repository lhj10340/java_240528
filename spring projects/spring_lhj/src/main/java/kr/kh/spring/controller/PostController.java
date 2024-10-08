package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Pagination.PageMaker;
import Pagination.PostCriteria;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostService;

// 게시글과 관련된 URL 을 처리하는 컨트롤러.
// URL 시작이 /post 로 시작.

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list")
	public String community(Model model, PostCriteria cri) {
		// 화면에 ${list} 출력하는 기능 ( 내가 한건 틀려서 .. 주석으로 처리하는게 아니라 전부 지웠다. )
		// 커뮤니티 리스트를 가져온다, 목록이니까 list 로 적어야한다.
		List<CommunityVO> list = postService.getCommunityList(); 
				
		// 현재 페이지 정보를 주면서 게시글 리스트를 가져오라고 시킨다.
		cri.setPerPageNum(2);
		List<PostVO> postList = postService.getPostList(cri);
		
		// 현재 페이지 정보를 주면서 페이지네이션 정보를 가져오라고 시킨다.
		PageMaker pm = postService.getPageMaker(cri);
		
		// 화면에 전송
		// model : 화면 전송할 때, 필요하다.
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);
		model.addAttribute("pm", pm);
		
		return "/post/list";
	}
	
	@GetMapping("/insert")
	public String Insert(Model model, Integer co_num) {
		model.addAttribute("co_num" ,co_num);
		return "/post/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(Model model, PostVO post, MultipartFile [] fileList,
			HttpSession session) {
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(postService.insertPost(post, user, fileList)) {
			model.addAttribute("url", "/post/list?co_num="+post.getPo_co_num());
			model.addAttribute("msg", "게시글을 등록했습니다.");
		}else {
			model.addAttribute("url", "/post/insert?co_num="+post.getPo_co_num());
			model.addAttribute("msg", "게시글을 등록하지 못했습니다..");
		}
		
		return "/main/message";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Integer po_num, PostCriteria cri) {
		
		// 게시글 호출 및 화면에 전송한다는 주석은 맞게 적었다.
		
		// 조회수 증가
		postService.updateView(po_num);
		
		// 게시글 호출
		PostVO post = postService.getPost(po_num);
		
		// 첨부파일 호출
		List<FileVO> list = postService.getFileList(po_num);
		
		// 화면에 전송
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		
		return "/post/detail";
	}
	
	@GetMapping("/update")
	public String update(Model model, Integer po_num, PostCriteria cri) {
		
		// 게시글 호출
		PostVO post = postService.getPost(po_num);
				
		// 첨부파일 호출
		List<FileVO> list = postService.getFileList(po_num);
		
		// 화면에 전송
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		
		return "/post/update";
	}
	
	@PostMapping("/update")
	public String updatePost(Model model, PostVO post, int [] fi_nums, MultipartFile [] fileList, PostCriteria cri, HttpSession session ) {
		
		MemberVO user = (MemberVO)session.getAttribute("user"); 
		
		if(postService.updatePost(post, fi_nums, fileList, user)) {
			model.addAttribute("url", "/post/detail?po_num="+post.getPo_num() + "&" + cri);
			model.addAttribute("msg", "게시글을 수정했습니다.");
		} else {
			model.addAttribute("url", "/post/detail?po_num="+post.getPo_num() + "&" + cri);
			model.addAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		return "/main/message";
	}
	
	// 
	
	@GetMapping("/delete")
	public String delete (Model model, HttpSession session, int po_num, PostCriteria cri) {
		
	MemberVO user = (MemberVO)session.getAttribute("user"); 
		
		if(postService.deletePost(po_num, user)) {
			model.addAttribute("url", "/post/list" + "?" + cri);
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		} else {
			model.addAttribute("url", "/post/detail?po_num="+po_num + "&" + cri);
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		return "/main/message";
		
	}
	
	@ResponseBody
	@PostMapping("/community/list")
	public List<CommunityVO> communityList(){
		return postService.getCommunityList();
	}
	
}
