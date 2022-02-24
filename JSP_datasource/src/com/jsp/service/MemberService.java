package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	// 회원리스트조회
	List<MemberVO> getMemberList() throws SQLException;
	
	MemberVO getMember(String id) throws SQLException;
	
	// 회원등록
	public void regist(MemberVO member) throws SQLException;
	

	// 회원수정
	void modify(MemberVO member) throws SQLException;
	
	// 회원삭제
	void remove(String id) throws SQLException;
}
