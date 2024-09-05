package kr.kh.spring_3.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring_3.dao.MemberDAO;
import kr.kh.spring_3.model.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		
		if(member == null) {
			return false;
		}
		// 회원 정규 표현식 검사
		if(!regexCheckMember(member)) {
			return false;
		}
		
		// 비밀번호 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		return memberDao.insertMember(member);
	}
	
	private boolean regexCheckMember(MemberVO member) {
		if(member == null || member.getMe_pw() == null || member.getMe_id() == null ) {
			return false;
		}
		if(!Pattern.matches("^\\w{6,13}$", member.getMe_id())) {
			return false;
		}
		if(!Pattern.matches("^[a-zA-Z0-9!@#$]{6,15}$", member.getMe_pw())) {
			return false;
		}
		
		return true;
	}

	public MemberVO login(MemberVO member) {
		
		if(member == null) {
			return null;
		}
		
		// 회원정보를 가져온다 ( 아이디를 이용한다 = 아이디 일치여부 확인 )
		MemberVO user = memberDao.selectMember(member.getMe_id());
		
		// 아이디가 일치하지 않았다.
		if(user == null) {
			return null;
		}
		
		// 비밀번호 확인
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}
	
}
