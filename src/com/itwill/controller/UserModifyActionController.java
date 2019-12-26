package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.member.Member;
import com.itwill.member.MemberService;
import com.itwill.summer.Controller;

public class UserModifyActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
//		String forwardPath = "";
		
		try{
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:error.do";
			}else {
			request.setCharacterEncoding("UTF-8");
			//String no = request.getParameter("p_no");
			String niname = request.getParameter("m_niname");
			String pass = request.getParameter("m_pass");
			String phone= request.getParameter("m_phone");
			String id= request.getParameter("m_id");
		
			MemberService memberService = new MemberService();
			Member createMember = new Member(niname, id, pass, phone);
			memberService.update(createMember);
			
			forwardPath = "redirect:emo_main.do";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return forwardPath;
	}
	
	
}

