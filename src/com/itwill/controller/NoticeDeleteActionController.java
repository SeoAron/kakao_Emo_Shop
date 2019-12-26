package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.notice.Notice;
import com.itwill.notice.NoticeService;
import com.itwill.summer.Controller;

public class NoticeDeleteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:.do";
		} else {
			try {
				String board_noStr = request.getParameter("board_no");
				NoticeService noticeService = new NoticeService();
				int deleteCnt = noticeService.deleteNotice(Integer.parseInt(board_noStr));
				if(deleteCnt == 0){
					forwardPath="forward:/WEB-INF/testview/kakaoerroepage.jsp";
				}else{
					forwardPath="redirect:noticetest.do";
				}
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/testview/kakaoerroepage.jsp";
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

}
