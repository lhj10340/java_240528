package kr.kh.spring_3.dao;

import java.util.List;

import kr.kh.spring_3.model.vo.CommunityVO;
import kr.kh.spring_3.model.vo.PostVO;
import kr.kh.spring_3.pagination.Criteria;
import kr.kh.spring_3.pagination.PostCriteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(Criteria cri);

	int selectPostTotalCount(PostCriteria cri);

}
