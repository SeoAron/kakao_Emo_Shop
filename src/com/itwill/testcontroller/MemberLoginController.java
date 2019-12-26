package com.itwill.testcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itwill.summer.Controller;

public class MemberLoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "redirect:user_login_action.do";
//		String forwardPath = "";
		
		
		
		
		return forwardPath;
	}
	
	
}
