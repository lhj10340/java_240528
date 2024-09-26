package kr.kh.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PageMaker;
import kr.kh.boot.pagination.PostCriteria;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	// @AllArgsConstructor 가 입력되서, @Autowired 가 하는 역할을 대신해준다.
	
	private PostDAO postDao;

	public List<PostVO> getPostList(PostCriteria cri) {
		
		// 커뮤니티가 선택되지 않았다면, ( url 이 list/0 이라면  ... ) 아무것도 표시되지 않도록!
		// 9/26 여기에 0 이라면 false 를 return 하도록 설정 .. ?
		// list.html 에 강사님 풀이 작성해놓음, 일단 생각해본건 틀리긴 했다.
		
		return postDao.selectPostList(cri);
	}

	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	public PageMaker getPageMaker(PostCriteria cri) {
		int count = postDao.selectCountPostList(cri);
		return new PageMaker(3, cri, count);
	}

	public void updateView(int po_num) {
		postDao.updateView(po_num);
	}

	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}

	public boolean addPost(PostVO post) {
		
		if(post == null) {
			return false;
		}
		
		try {
			return postDao.insertPost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updatePost(PostVO post) {
		
		if(post == null) {
			return false;
		}
		
		try {
			return postDao.updatePost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletePost(int po_num) {
		return postDao.deletePost(po_num);
	}

}
