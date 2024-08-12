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
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;


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
	public CommunityVO getCommunity(int coNum) {
		
		return postDao.selectCommunity(coNum);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			System.out.println(cri);
			throw new RuntimeException();
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		if(cri == null) {
			System.out.println(cri);
			throw new RuntimeException();
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, displayPageNum, cri);
	}

	@Override
	public boolean insertPost(PostVO post) {
		if(post == null) {
			return false;
		}
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		return postDao.insertPost(post);
	}

	@Override
	public PostVO getPost(int num) {
		
		return postDao.selectPost(num);
	}

	@Override
	public void updatePostView(int num) {
		postDao.updatePostView(num);
	}

	@Override
	public PostVO getPost(int po_num, MemberVO user) {
		// 회원이 null 이면 null 을 반환.
		if(user == null) {
			return null;
		}
		// 게시글 번호에 맞는 게시글을 가져온다.
		PostVO post = postDao.selectPost(po_num);
		// 게시글이 null 이면 null 을 반환.
		if(post == null) {
			return null;
		}
		// 게시글의 작성자와 회원 아이디가 같으면 게시글을 반환하고
		if(checkWriter(po_num, user)) {
			return post;
		}
		// 아니면 null 을 반환.
		return null;
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		if(post == null || user == null) {
			return false;
		}
		if(!checkWriter(post.getPo_num(), user)) {
			return false;
		}
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		return postDao.updatePost(post);
	}
	
	// 게시글의 작성자인지 아닌지 확인하는 메소드
	private boolean checkWriter(int po_num, MemberVO user) {
		// 회원이 null 이면 null 을 반환.
		if(user == null) {
			return false;
		}
		// 게시글 번호에 맞는 게시글을 가져온다.
		PostVO post = postDao.selectPost(po_num);
		// 게시글이 null 이면 null 을 반환.
		if(post == null) {
			return false;
		}
		// 게시글의 작성자와 회원 아이디가 같으면 true 를 반환
		if(post.getPo_me_id().equals(user.getMe_id())) {
			return true;
		}
		// 아니면 null 을 반환.
		return false;
	}

	@Override
	public boolean deletePost(String po_num, MemberVO user) {
		try {
			int poNum = Integer.parseInt(po_num);
			if(!checkWriter(poNum, user)) {
				return false;
			}
			return postDao.deletePost(poNum);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
