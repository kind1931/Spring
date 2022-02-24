package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

/**
 * Servlet implementation class DispatcherSerlvet
 */
public class DispatcherServlet extends HttpServlet {

	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String handlerProperty = config.getInitParameter("urlProperty");
		try {
			if(handlerProperty != null && !handlerProperty.isEmpty()) {
				//HandlerMapper 클래스의 생성자에 에 throws Exception을 했기 때문에 여기서 try catch가 가능
				//HandlerMapper 에서 try catch 를 했다면 객체생성 성공/실패 결과를 받아볼 수 없음.
				handlerMapper = new HandlerMapper(handlerProperty);
			} else {
				handlerMapper = new HandlerMapper();
			}
			System.out.println("[DispatcherSerlvet] handlerMapper 가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[DispatcherSerlvet] handlerMapper 가 준비되지 않았습니다.");
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 URI 검출
		String command = request.getRequestURI();	// contextPath 포함. (JSP_command)
		if (command.indexOf(request.getContextPath()) == 0) {	//contextPath 삭제
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandler 실행 (HandlerMapper 의뢰  handler 할당)
		Action action = null;
		String message = null;
		
		if(handlerMapper != null) {
			action = handlerMapper.getAction(command);
			if(action!=null) {	//올바른 요청
				message = action.execute(request, response);
				System.out.println("message : "+message);
				response.getWriter().print(message);
			}else {
				//tomcat에 있는 Error 페이지를 내보내줌.
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}


}
