package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.jumun.Jumun;
import com.itwill.jumun.JumunService;
import com.itwill.member.Member;
import com.itwill.summer.Controller;

public class EmoBuyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		Jumun jumun = null;
		
		try {
			JumunService jumunService = new JumunService();
			jumunService.add(member.getM_no());
			jumun = jumunService.getJumun(member.getM_no());
			
			request.setAttribute("jumun", jumun);
			
			forwardPath = "forward:/WEB-INF/view/jumun_form.jsp";
			
		} catch (Exception e) {
			forwardPath = "redirect:error.do";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
