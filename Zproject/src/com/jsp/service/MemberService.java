package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	// 회원리스트조회
	List<MemberVO> getMemberList() throws SQLException;
	
	MemberVO getMember(String id) throws SQLException;
	
	int registerMember(MemberVO memberVO) throws SQLException;
	
	int modifyMember(MemberVO memberVO) throws SQLException;

	int deleteMember(String id) throws SQLException;
}
