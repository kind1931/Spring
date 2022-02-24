package com.jsp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NullCheckFilter implements Filter {
	//사라질때
	public void destroy() {
	}
	//컨텍스path가 배포될때(요청이 없어도)
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response); //세션못가져옴(httpx) 목적지 없이 다음으로 넘기.최종필터는 서블릿에게 넘김
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		boolean isNotNull = true;
		
		isNotNull = isNotNull && (id!=null);
		isNotNull = isNotNull && (pwd!=null);
		
		if(!isNotNull) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('아이디 혹은 패스워드가 존재하지 않습니다.');");
			out.println("</script>");
			
			return;
			
		} else {
			chain.doFilter(request, response);
		}
				
	}


}
