package com.jsp.controller;

import java.io.IOException;
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

public class MemeberInsertServlet extends HttpServlet {
	

	private MemberService memberService ;
	
	
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
		String url = "/WEB-INF/views/member/insertform.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/alert_page.jsp";
		String target = "list.do";
		String msg = "회원등록 실패하였습니다.";
		
		MemberVO memberVO = new MemberVO();
		String id = (String)request.getParameter("id");
		String name = (String) request.getParameter("name");
		String pwd = (String) request.getParameter("pwd");
		String address = (String) request.getParameter("address");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		
		memberVO.setId(id);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setPwd(pwd);
		memberVO.setAddress(address);
		memberVO.setEmail(email);
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(pwd);
		System.out.println(address);
		System.out.println(email);
		
		try {
			int cnt = memberService.registerMember(memberVO);
			if(cnt == 1 ) {
				msg = "회원등록이 완료되었습니다.";
				System.out.println("memberService register clear!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("target", target);
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
