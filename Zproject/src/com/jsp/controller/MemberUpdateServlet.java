package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;


public class MemberUpdateServlet extends HttpServlet {
	
	private MemberService memberService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * SqlSessionFactory sqlSessionFatory = new OracleMybatisSqlSessionFactory();
		 * MemberDAO memberDAO = new MemberDAOImpl();
		 */
		String memberServiceStr = config.getInitParameter("memberService");
		String memberDAOStr = config.getInitParameter("memberDAO");
		String sqlSessionFactoryStr = config.getInitParameter("sqlSessionFactory");
		
		try {
			memberService = (MemberService)Class.forName(memberServiceStr).newInstance();
			MemberDAO memberDAO = (MemberDAO)Class.forName(memberDAOStr).newInstance();
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)Class.forName(sqlSessionFactoryStr).newInstance();
			
					
			
			if(memberService instanceof MemberServiceImpl ) {
				MemberServiceImpl memberServiceImpl = (MemberServiceImpl)memberService;
				memberServiceImpl.setSqlSessionFactory(sqlSessionFactory);
				memberServiceImpl.setMemberDAO(memberDAO);
				
				System.out.println("memberService injection clear!");
			}
		}catch(Exception e) {
			System.out.println("초기화 실패입니다.");
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/WEB-INF/views/member/updateform.jsp";
		
		String id = request.getParameter("id");
				
		MemberVO member = null;
		
		try {
			member=memberService.getMember(id);
			
			request.setAttribute("member", member);
		} catch (SQLException e) {
			url="/WEB-INF/views/member/update_fail.jsp";
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		String msg = "회원정보 수정이 정상적으로 완료되지 않았습니다.";
		String url = "/WEB-INF/views/member/alert_page.jsp";
		String target = "update.do?id="+id;

		
		MemberVO member = new MemberVO();
		if(id != null) {member.setId(id);}
		if(pwd != null) {member.setPwd(pwd);}
		if(name != null) {member.setName(name);}
		if(email != null) {member.setEmail(email);}
		if(phone != null) {member.setPhone(phone);}
		if(address != null) {member.setAddress(address);}
		try {
			
			int cnt = memberService.modifyMember(member);
			if(cnt == 0) {
			} else {
				msg = "정상적으로 수정되었습니다.";
				target = "detail.do?id="+id;
				System.out.println("회원정보가 정상적으로 수정되었습니다.");
			}
		
			request.setAttribute("target", target);
			request.setAttribute("msg", msg);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
