package kr.kh.spring_3.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.kh.spring_3.model.vo.CommunityVO;
import kr.kh.spring_3.model.vo.PostVO;
import kr.kh.spring_3.pagination.PageMaker;
import kr.kh.spring_3.pagination.PostCriteria;
import kr.kh.spring_3.service.PostService;

@RestController
@RequestMapping("/react")
public class ReactController {
	@Autowired
	PostService postService;
	
	@GetMapping("/community/list")
	public List<CommunityVO> communityList() {
		return postService.getCommunityList();
	}
	
	@GetMapping("/post/list/{co_num}")
	public Map<String, Object> list(Model model, @PathVariable("co_num")int co_num, PostCriteria cri) {
		cri.setCo_num(co_num);
		cri.setPerPageNum(3);
		//게시글 목록을 가져옴(전체)
		List<PostVO> list = postService.getPostList(cri);
		
		//페이지메이커 
		PageMaker pm = postService.getPageMaker(cri);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pm", pm);
		return map;
		
	}
	
	@GetMapping("/post/detail/{po_num}")
	public PostVO postDetail(@PathVariable("po_num")int po_num) {
		return postService.getPost(po_num);
	}
}