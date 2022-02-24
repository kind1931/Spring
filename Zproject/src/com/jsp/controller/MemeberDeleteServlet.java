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

public class MemeberDeleteServlet extends HttpServlet {
	

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
		String id = (String)request.getParameter("id");
		
		String url = "/WEB-INF/views/member/alert_page.jsp";
		String target = "detail?id="+id;
		String msg = "회원 삭제실패하였습니다.";
		
		try {
			int cnt = memberService.deleteMember(id);
			if(cnt > 0 ) {
				msg = "삭제가 정상적으로 이루어졌습니다.";
				target = null;
				System.out.println("memeber delete success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("target", target);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
