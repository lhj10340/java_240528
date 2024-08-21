package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagnation.Criteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	CommunityVO selectCommunity(@Param("co_num")String num);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectPostTotalCount(@Param("cri")Criteria cri);


}