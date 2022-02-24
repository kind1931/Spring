package com.jsp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {

	//context parameter 사용함(init parameter가 아닌)
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent event)  {
    	
    					//어디서,무엇 두정보다 가지고 있음 , Context객체를 가지고 있음.
    	System.out.println("TestLisenter loading !!!!!!");
    	
    	String message = event.getServletContext().getInitParameter("message");
    	System.out.println(message);
    }
    
	
}
