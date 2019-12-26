package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.EmoService;
import com.itwill.notice.Notice;
import com.itwill.notice.NoticeService;
import com.itwill.summer.Controller;

public class EmoDeleteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="forward:/WEB-INF/testview/kakaoerroepage.jsp";
		} else {
			try {
				String noStr = request.getParameter("p_no");
				EmoService emoService = new EmoService();
				emoService.delete(Integer.parseInt(noStr));
				forwardPath= "redirect:emo_main.do";
				
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/testview/kakaoerroepage.jsp";
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

}
