package kr.kh.spring_2.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring_2.dao.MemberDAO;
import kr.kh.spring_2.model.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
    MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		
		if(member == null) {
		// 계속 false 대신 null 로 쓰면서 해메고 있었다.
			return false;
		}
		if(!checkRegex(member.getMe_id(), "^\\w{6,13}$")) {
			return false;
		}
		if(!checkRegex(member.getMe_pw(), "^[a-zA-Z0-9!@#$]{6,15}$")) {
			return false;
		}
		
		// 비밀번호 암호화
		// 여기에 넣어야 하는 것도 잘 생각하지 못 했다.
		String encPw = passwordEncoder.encode(member.getMe_pw());
		
		// 암호화된 비밀번호로 변경
		// 이 부분을 생각하지 못 했다.
		member.setMe_pw(encPw);
		
		try {
			// 아이디 중복, 이메일 중복일 때 예외 발생
			// 예외를 체크하지 못했다.
			return memberDao.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	private boolean checkRegex(String str, String regex) {
		if(str != null && Pattern.matches(regex, str)) {
			return true;
		}
		return false;
	}
    
}
