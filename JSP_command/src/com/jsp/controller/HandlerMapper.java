package com.jsp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;

public class HandlerMapper {
	
	private static final String path = "com/jsp/properties/url"; 
	
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	public HandlerMapper() throws Exception {
		this(path);
	}
	
	//property path 받아서 그 파일을 읽어서 commandMap 만드는 부분
	public HandlerMapper(String path) throws Exception {
		//property파일을 분석해서 command 와 url를 분리해주는 녀석
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Set<String> actionSetHome = rbHome.keySet(); // uri set
		
		Iterator<String> it = actionSetHome.iterator();
		while(it.hasNext()) {
			String command = it.next();
			String actionClassName = rbHome.getString(command);
			
			Class<?> actionClass = Class.forName(actionClassName);
			Action commandAction = (Action) actionClass.newInstance();
			
			commandMap.put(command, commandAction);
			System.out.println("[HandlerMapper]" + command
							+ ":" + commandAction + " 가 준비되었습니다.");
		}
		
	}
	
	public Action getAction(String url) {
		Action action = commandMap.get(url);
		return action;
	}
}
