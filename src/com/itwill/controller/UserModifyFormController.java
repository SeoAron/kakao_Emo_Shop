package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.member.Member;
import com.itwill.member.MemberService;
import com.itwill.summer.Controller;

public class UserModifyFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	//	String forwardPath = "forward:/WEB-INF/testview/memberModifyForm.jsp";
		String forwardPath = "";
		
			try {
			
				String m_id = (String)request.getSession().getAttribute("sUserId");
//				String m_id = request.getParameter("m_id");
				MemberService memberService=new MemberService();
				Member member = memberService.findMember(m_id);
				
				request.setAttribute("member",member);
				
				forwardPath="forward:/WEB-INF/view/member_modify.jsp";
				//forwardPath="redirect:user_modify_form.do";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:error.do";
			}
		
		
		
		
		return forwardPath;
	}
	
	
}
