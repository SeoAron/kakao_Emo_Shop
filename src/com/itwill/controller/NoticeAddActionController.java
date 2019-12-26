package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.notice.Notice;
import com.itwill.notice.NoticeService;
import com.itwill.summer.Controller;

public class NoticeAddActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:notice_list.do";
			}else {
				String board_title = request.getParameter("board_title");
				String board_writer = request.getParameter("board_writer");
				String board_content = request.getParameter("board_content");
				NoticeService noticeService = new NoticeService();
				int insertCnt = noticeService.createNotice(board_title, board_writer, board_content);
				if(insertCnt == 0){
					forwardPath="forward:/WEB-INF/testview/kakaoerroepage.jsp";
				}else{
					forwardPath="redirect:notice_list.do";
				}
			}
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/testview/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
