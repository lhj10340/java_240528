package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagnation.Criteria;
import kr.kh.app.pagnation.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(String num);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPostPageMaker(Criteria cri);


}
