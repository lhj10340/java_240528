package db.community.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.PostDAO;
import db.community.model.vo.CommunityVO;

public class PostServiceImp implements PostService {
	
	private PostDAO postDao;
	
	public PostServiceImp() {
		String resource = "db/community/config/mybatis-config.xml";
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
	public boolean insertCommunity(String community) {
		
		// 커뮤니티명 null 체크, 빈 문자열 체크
		if(community == null || community.trim().length() == 0) {
			return false;
		}
		community = community.trim();
		// 중복 확인
		// dao 에게 커뮤니티명을 주고 db에 있는 커뮤니티 정보를 달라고 요청
		CommunityVO communityVo = postDao.selectCommunity(community);
		// 커뮤니티 정보가 null 이 아니면 false를 리턴
		if(communityVo != null) {
			return false;
		}
		// dao 에게 커뮤니티명을 추고 db에 추가하라고 시킨 후, 성공 여부를 리턴
		return postDao.insertCommunity(community);
	}

	@Override
	public boolean updateCommunity(String oldName, String newName) {
		
		// 이전 커뮤니티명과 이후 커뮤니티명 중에 null 이 있거나 이후 커뮤니티명의 길이가 0이면 false 를 리턴
		if(oldName == null || newName == null || newName.trim().length() == 0) {
			return false;
		}
		// 이전 커뮤니티명과 이후 커뮤니티명이 같으면 false 를 리턴
		if(oldName.equals(newName)) {
			return false;
		}
		// 등록된 커뮤니티명이어애 수정할 수 있다.
		// 이전 커뮤니티명을 이용해서 커뮤니티VO 를 가져온다.
		CommunityVO oldVo = postDao.selectCommunity(oldName);
		
		//커뮤니티 VO가 null 이면 false 를 리턴
		if(oldVo == null) {
			return false;
		}
		// 바꾸려는 커뮤니티명이 이미 등록되어있다면 수정할 수 없다.
		// 이후 커뮤니티명을 이용해서 커뮤니티VO 를 가져온다.
		CommunityVO newVo = postDao.selectCommunity(newName);
		// 이후 커뮤니티VO 가 null 이 아니면 false 를 리턴
		if(newVo != null) {
			return false;
		}
		// 이전 커뮤니티VO의 커뮤니티명을 이후 커뮤니티명으로 수정 ??? 이거 못 했다.
		oldVo.setCo_name(newName.trim());
		// dao 에게 이전 커뮤니티VO를 주면서 커뮤니티명을 수정하라고 요청하고 처리 여부를 반환
		return postDao.updateCommunity(oldVo);
	}
}
