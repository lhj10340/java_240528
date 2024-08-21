package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.vo.MemberVO;


public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkRegex(String str, String regex) {
		if(str == null || regex == null) {
			return false;
		}
		return Pattern.matches(regex, str);
	}
	
	@Override // 이 메소드는 작성하지 못 했다.
	public boolean signup(MemberVO member) {
		// member null 체크
		if(member == null) {
			return false;
		}
		// 아이디 유효성 검사
		if(!checkRegex(member.getMe_id(), "\\w{6,13}$" )) {
			return false;
		}
		// 비밀번호 유효성 검사
		if(!checkRegex(member.getMe_pw(), "^[a-zA-Z0-9!@#$]{6,15}$" )) {
			return false;
		}
		// 이메일 유효성 검사
		if(!checkRegex(member.getMe_email(), "^[A-Za-z0-9_]+@[A-Za-z0-9_]+(\\.[A-Za-z]{2,}){1,}$" )) {
			return false;
		}
		try {
			return memberDao.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean checkId(String me_id) {
		return memberDao.selectMember(me_id) == null;
	}

	@Override
	// 여기부터는 못 건드렸다, 이전꺼를 다 못 마쳐서 ...
	public MemberVO login(MemberVO member) {
		
		if(member == null) {
			return null;
		}
		
		MemberVO user = memberDao.selectMember(member.getMe_id());
		// 가입되지 않은 아이디라면 ...
		if(user == null) {
			return null;
		}
		
		// 비밀번호가 같으면 ... ( 비밀번호를 이렇게 따로 둔 이유는 나중에 스프링에서는 암호화를 할 것이기 때문이다. )
		if(user.getMe_pw().equals(member.getMe_pw())) {
		
		return user;
		}
		return null;
	}
}