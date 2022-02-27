package com.jsp.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.exception.IdNotFoundException;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.service.LoginSearchMemberService;

public class LoginAction implements Action {

	private LoginSearchMemberService loginSearchMemberService;
	
	
	public void setLoginSearchMemberService(LoginSearchMemberService loginSearchMemberService) {
		this.loginSearchMemberService = loginSearchMemberService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="redirect:index.do"; // /가 2개면 도메인도 없애버림
		
		//입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try {
			loginSearchMemberService.login(id, pwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginSearchMemberService.getMember(id));
			session.setMaxInactiveInterval(60*6); //세션유지시간
			
		} catch (IdNotFoundException | InvalidPasswordException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			url = "common/login_fail";
		
		} catch (Exception e) {
			e.printStackTrace();
			//Exception 처리
			throw e;
		}
		
		return url;
	}

}
