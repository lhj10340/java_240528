package kr.kh.spring_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring_3.dao.PostDAO;
import kr.kh.spring_3.model.vo.CommunityVO;
import kr.kh.spring_3.model.vo.PostVO;
import kr.kh.spring_3.pagination.Criteria;
import kr.kh.spring_3.pagination.PageMaker;
import kr.kh.spring_3.pagination.PostCriteria;

@Service
public class PostService {
	
	@Autowired
	PostDAO postDao;
	
	@Autowired

	public List<CommunityVO> getCommunityList() {
		
		return postDao.selectCommunityList();
	}

	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			return null;
		} System.out.println((PostCriteria)cri);
		return postDao.selectPostList(cri);
	}

	public PageMaker getPageMaker(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(3, cri, totalCount);
	}
	
}
