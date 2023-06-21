package com.app;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.app.member.domain.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
//	아이디 중복검사
	public String selectIdentification(String memberIdentification) {
		return sqlSession.selectOne("memberIdentification",memberIdentification);
	}
	public Long login(String memberIdentification, String memberPassword) {
		HashMap<String, String> loHashMap = new HashMap();
		loHashMap.put("memberIdentification", memberIdentification);
		loHashMap.put("memberPassword", memberPassword);
		
		return sqlSession.selectOne("member.login", loHashMap);
		
	}
}
