package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.Emo;
import com.itwill.emo.EmoService;
import com.itwill.summer.Controller;

public class EmoStyleController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			EmoService emoService = new EmoService();
			// 이모티콘 스타일별로 5개씩 뽑기
						ArrayList<String> styleNameList = emoService.getEmoStyleNameList();
						List<Emo> emoList = emoService.getEmoList();
						request.setAttribute("emoList", emoList);
						request.setAttribute("styleNameList", styleNameList);
			
			request.setAttribute("styleNameList", styleNameList);
			forwardPath = "forward:/WEB-INF/view/emo_Style.jsp";
			
			
			
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
