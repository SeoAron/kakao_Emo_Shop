package com.itwill.testcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.member.Member;
import com.itwill.member.MemberService;
import com.itwill.summer.Controller;

public class MemberModifyformController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	//	String forwardPath = "forward:/WEB-INF/testview/memberModifyForm.jsp";
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:error.do";
		}else {
			try {
				String m_id = request.getParameter("m_id");
				MemberService memberService=new MemberService();
				Member member = memberService.findMember(m_id);
				request.setAttribute("member",member);
				forwardPath="forward:/WEB-INF/testview/memberModifyForm.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:error.do";
			}
		}
		
		
		
		return forwardPath;
	}
	
	
}
