package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.EmoService;
import com.itwill.member.MemberService;
import com.itwill.notice.Notice;
import com.itwill.notice.NoticeService;
import com.itwill.summer.Controller;

public class UserDeleteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="forward:/WEB-INF/testview/kakaoerroepage.jsp";
		} else {
			try {
				String idStr = request.getParameter("m_id");
				MemberService memberService = new MemberService();
				memberService.remove(idStr);
				forwardPath= "redirect:emo_main.do";
				
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/testview/kakaoerroepage.jsp";
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

}
