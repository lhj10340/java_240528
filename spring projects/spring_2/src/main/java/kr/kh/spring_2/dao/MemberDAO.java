package kr.kh.spring_2.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring_2.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("m")MemberVO member);
	
}
