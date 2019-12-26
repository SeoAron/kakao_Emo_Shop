package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.notice.Notice;
import com.itwill.notice.NoticeService;
import com.itwill.summer.Controller;

public class NoticeListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		try {
			NoticeService noticeService = new NoticeService();
			ArrayList<Notice> noticeList = noticeService.getNoticeList();
			request.setAttribute("noticeList", noticeList);
			//forwardPath = "redirect:emo_main.do";
			forwardPath = "forward:/WEB-INF/view/notice_List.jsp";
			
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
