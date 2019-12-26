package com.itwill.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.exception.PasswordMismatchException;
import com.itwill.exception.UserNotFoundException;
import com.itwill.member.Member;
import com.itwill.member.MemberService;
import com.itwill.summer.Controller;

public class UserLoginActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	//	String forwardPath = "forward:/WEB-INF/testview/memberLogin.jsp";
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			
		}
		Member loginUser=null;
		try{
			
			String userId=request.getParameter("m_id");
			String password=request.getParameter("m_pass");
			MemberService userService=new MemberService();
			loginUser=userService.login(userId,password);
			request.getSession().setAttribute("sUserId", userId);
			request.getSession().setAttribute("member", loginUser);
			forwardPath = "redirect:emo_main.do";
			
//		}catch(UserNotFoundException e){
//			
//			String msg1 = URLEncoder.encode(e.getMessage(), "UTF-8");
//			response.sendRedirect("user_login_form.jsp?msg1="+msg1);
//			
//		}catch(PasswordMismatchException e){
//			
//			String msg2 = URLEncoder.encode(e.getMessage(), "UTF-8");
//			response.sendRedirect("user_login_form.jsp?msg2="+msg2);
			
		
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
		}
		
		
		
		return forwardPath;
	}
	
	
}
