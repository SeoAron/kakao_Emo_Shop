package com.itwill.testcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class memberWriteFormControllerTest implements Controller{

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		String forwardPath = "forward:/WEB-INF/testview/memWriteFormTest.jsp";
		return forwardPath;
	}
	
}
