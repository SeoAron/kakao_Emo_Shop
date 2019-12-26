package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.itwill.summer.Controller;

public class EmoInsertController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "forward:/WEB-INF/view/emo_Insert.jsp";
//		String forwardPath = "";
		
		//session session = request.getSession();
		//Session session = (Session) request.getSession();
		
		
		return forwardPath;
	}
	
	
}
