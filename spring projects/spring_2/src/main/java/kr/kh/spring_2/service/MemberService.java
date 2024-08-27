package kr.kh.spring_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring_2.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
    MemberDAO memberDao;
    
}
