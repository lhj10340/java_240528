package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Override
	public Cookie createCookie(MemberVO user, HttpServletRequest request) {
		if(user == null) {
			return null;
		}
		HttpSession session = request.getSession();
		
		// 쿠키는 이름, 값, 만료시간, path 가 필요하다.
		String me_cookie = session.getId();
		// 쿠키 이름이 AL, 값은 현재 세션 아이디의 값
		Cookie cookie = new Cookie("AL", me_cookie);
		cookie.setPath("/");
		// 1주일의 시간
		int time = 60 * 60 * 24 * 7; 
		cookie.setMaxAge(time);
		
		// 쿠키를 DB 에 추가하는 과정
		
		user.setMe_cookie(me_cookie);
		// 만료시간은 현재 시간 + 1주일 뒤
		Date date = new Date(System.currentTimeMillis() + time * 1000);
		user.setMe_limit(date);
		memberDao.updateMemberCookie(user);
		return cookie;
	}

	@Override
	public MemberVO getMemberBySid(String sid) {
		
		return memberDao.selectMemberBySid(sid);
	}

	@Override
	public void updateMemberCookie(MemberVO user) {
		
		memberDao.updateMemberCookie(user);
		
	}
}