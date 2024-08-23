package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagnation.Criteria;
import kr.kh.app.pagnation.PageMaker;

public class PostServiceImp implements PostService {

	private PostDAO postDao;
	
	public PostServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CommunityVO> getCommunityList() {
		
		return postDao.selectCommunityList();
	}

	@Override
	public CommunityVO getCommunity(String num) {
		
		return postDao.selectCommunity(num);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPostPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, 5, cri);
	}

	@Override
	public PostVO getPost(String po_num) {
		
		return postDao.selectPost(po_num);
	}

	@Override
	public void updatePostView(String po_num) {
		
		postDao.updatePostView(po_num);
	}

	@Override
	public boolean insertPost(PostVO post) {
		
		if(post == null) {
			return false;
		}
		
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0){
			return false;
		}
		
		try {
			return postDao.insertPost(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		
		if(post == null) {
			return false;
		}
		
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0){
			return false;
		}
		
		PostVO dbPost = postDao.selectPost(post.getPo_num() + "");
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id()) || user == null) {
			return false;
		}
		
		try {
			return postDao.updatePost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deletePost(String po_num, MemberVO user) {
		
		// 회원이 로그인 되어있어야 한다.
		if(user == null) {
			return 0;
		}
		
		// 게시글을 확인한다.
		PostVO post = postDao.selectPost(po_num);
		
		// 게시글이 있어야 한다.
		if(post == null) {
			return 0;
		}
		
		// 게시글의 작성자와 로그인한 작성자가 같아야한다.
		if(!post.getPo_me_id().equals(user.getMe_id())) {
			return 0;
		}
		
		postDao.deletePost(po_num);
		return post.getPo_co_num();
		
	}

}
